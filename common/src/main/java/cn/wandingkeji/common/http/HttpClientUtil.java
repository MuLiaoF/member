package cn.wandingkeji.common.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.*;


public class HttpClientUtil {
	
	public static final String SunX509 = "SunX509";
	public static final String JKS = "JKS";
	public static final String PKCS12 = "PKCS12";
	public static final String TLS = "TLS";

	/**
	 * 编码格式。发送编码格式统一用UTF-8
	 */
	private static final String ENCODING = "UTF-8";

	/**
	 * 设置连接超时时间，单位毫秒。
	 */
	private static final Integer CONNECT_TIMEOUT = 6000;

	/**
	 * 请求获取数据的超时时间(即响应时间)，单位毫秒。
	 */
	private static final Integer SOCKET_TIMEOUT = 6000;

	/**
	 * get HttpURLConnection
	 * @param strUrl url地址
	 * @return HttpURLConnection
	 * @throws IOException
	 */
	public static HttpURLConnection getHttpURLConnection(String strUrl)
			throws IOException {
		URL url = new URL(strUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url
				.openConnection();
		return httpURLConnection;
	}
	
	/**
	 * get HttpsURLConnection
	 * @param strUrl url地址
	 * @return HttpsURLConnection
	 * @throws IOException
	 */
	public static HttpsURLConnection getHttpsURLConnection(String strUrl)
			throws IOException {
		URL url = new URL(strUrl);
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url
				.openConnection();
		return httpsURLConnection;
	}
	
	/**
	 * 获取不带查询串的url
	 * @param strUrl
	 * @return String
	 */
	public static String getURL(String strUrl) {

		if(null != strUrl) {
			int indexOf = strUrl.indexOf("?");
			if(-1 != indexOf) {
				return strUrl.substring(0, indexOf);
			} 
			
			return strUrl;
		}
		
		return strUrl;
		
	}
	
	/**
	 * 获取查询串
	 * @param strUrl
	 * @return String
	 */
	public static String getQueryString(String strUrl) {
		
		if(null != strUrl) {
			int indexOf = strUrl.indexOf("?");
			if(-1 != indexOf) {
				return strUrl.substring(indexOf+1, strUrl.length());
			} 
			
			return "";
		}
		
		return strUrl;
	}
	
	/**
	 * 查询字符串转换成Map<br/>
	 * name1=key1&name2=key2&...
	 * @param queryString
	 * @return
	 */
	public static Map queryString2Map(String queryString) {
		if(null == queryString || "".equals(queryString)) {
			return null;
		}
		
		Map m = new HashMap();
		String[] strArray = queryString.split("&");
		for(int index = 0; index < strArray.length; index++) {
			String pair = strArray[index];
			HttpClientUtil.putMapByPair(pair, m);
		}
		
		return m;
		
	}
	
	/**
	 * 把键值添加至Map<br/>
	 * pair:name=value
	 * @param pair name=value
	 * @param m
	 */
	public static void putMapByPair(String pair, Map m) {
		
		if(null == pair || "".equals(pair)) {
			return;
		}
		
		int indexOf = pair.indexOf("=");
		if(-1 != indexOf) {
			String k = pair.substring(0, indexOf);
			String v = pair.substring(indexOf+1, pair.length());
			if(null != k && !"".equals(k)) {
				m.put(k, v);
			}
		} else {
			m.put(pair, "");
		}
	}
	
	/**
	 * BufferedReader转换成String<br/>
	 * 注意:流关闭需要自行处理
	 * @param reader
	 * @return String
	 * @throws IOException
	 */
	public static String bufferedReader2String(BufferedReader reader) throws IOException {
		StringBuffer buf = new StringBuffer();
		String line = null;
		while( (line = reader.readLine()) != null) {
			buf.append(line);
			buf.append("\r\n");
		}
				
		return buf.toString();
	}
	
	/**
	 * 处理输出<br/>
	 * 注意:流关闭需要自行处理
	 * @param out
	 * @param data
	 * @param len
	 * @throws IOException
	 */
	public static void doOutput(OutputStream out, byte[] data, int len) 
			throws IOException {
		int dataLen = data.length;
		int off = 0;
		while(off < dataLen) {
			if(len >= dataLen) {
				out.write(data, off, dataLen);
			} else {
				out.write(data, off, len);
			}
			
			//刷新缓冲区
			out.flush();
			
			off += len;
			
			dataLen -= len;
		}
		
	}
	
	/**
	 * 获取SSLContext
	 * @param trustFileInputStream
	 * @param trustPasswd
	 * @param keyFileInputStream
	 * @param keyPasswd
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws CertificateException 
	 * @throws UnrecoverableKeyException 
	 * @throws KeyManagementException 
	 */
	public static SSLContext getSSLContext(
			FileInputStream trustFileInputStream, String trustPasswd,
			FileInputStream keyFileInputStream, String keyPasswd)
			throws NoSuchAlgorithmException, KeyStoreException,
			CertificateException, IOException, UnrecoverableKeyException,
			KeyManagementException {

		// ca
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(HttpClientUtil.SunX509);
		KeyStore trustKeyStore = KeyStore.getInstance(HttpClientUtil.JKS);
		trustKeyStore.load(trustFileInputStream, HttpClientUtil
				.str2CharArray(trustPasswd));
		tmf.init(trustKeyStore);

		final char[] kp = HttpClientUtil.str2CharArray(keyPasswd);
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(HttpClientUtil.SunX509);
		KeyStore ks = KeyStore.getInstance(HttpClientUtil.PKCS12);
		ks.load(keyFileInputStream, kp);
		kmf.init(ks, kp);

		SecureRandom rand = new SecureRandom();
		SSLContext ctx = SSLContext.getInstance(HttpClientUtil.TLS);
		ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), rand);

		return ctx;
	}
	
	/**
	 * 获取CA证书信息
	 * @param cafile CA证书文件
	 * @return Certificate
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static Certificate getCertificate(File cafile)
			throws CertificateException, IOException {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream(cafile);
		Certificate cert = cf.generateCertificate(in);
		in.close();
		return cert;
	}
	
	/**
	 * 字符串转换成char数组
	 * @param str
	 * @return char[]
	 */
	public static char[] str2CharArray(String str) {
		if(null == str) return null;
		
		return str.toCharArray();
	}
	
	/**
	 * 存储ca证书成JKS格式
	 * @param cert
	 * @param alias
	 * @param password
	 * @param out
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static void storeCACert(Certificate cert, String alias,
			String password, OutputStream out) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException {
		KeyStore ks = KeyStore.getInstance("JKS");

		ks.load(null, null);

		ks.setCertificateEntry(alias, cert);

		// store keystore
		ks.store(out, HttpClientUtil.str2CharArray(password));

	}
	
	public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}




	// 创建CookieStore实例
	static CookieStore cookieStore = null;
	static HttpClientContext context = null;

	/**
	 * 发送get请求；不带请求头和请求参数
	 *
	 * @param url 请求地址
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url) throws Exception {
		return doGet(url, null, null);
	}

	/**
	 * 发送get请求；带请求参数
	 *
	 * @param url    请求地址
	 * @param params 请求参数集合
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url, Map<String, String> params) throws Exception {
		return doGet(url, null, params);
	}

	/**
	 * 发送get请求；带请求头和请求参数
	 *
	 * @param url     请求地址
	 * @param headers 请求头集合
	 * @param params  请求参数集合
	 * @return
	 * @throws Exception
	 */
	public static String doGet(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
		// 创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 创建访问的地址
		URIBuilder uriBuilder = new URIBuilder(url);
		if (params != null) {
			Set<Map.Entry<String, String>> entrySet = params.entrySet();
			for (Map.Entry<String, String> entry : entrySet) {
				uriBuilder.setParameter(entry.getKey(), entry.getValue());
			}
		}

		// 创建http对象
		HttpGet httpGet = new HttpGet(uriBuilder.build());
		/**
		 * setConnectTimeout：设置连接超时时间，单位毫秒。
		 * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
		 * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
		 * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。
		 * 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
		 */
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
		httpGet.setConfig(requestConfig);

		// 设置请求头
		packageHeader(headers, httpGet);

		// 创建httpResponse对象
		CloseableHttpResponse httpResponse = null;

		//响应结果
		String result = "";
		try {

			// 执行请求
			httpResponse = httpClient.execute(httpGet);

			// 获取返回结果
			if (httpResponse != null && httpResponse.getStatusLine() != null) {
				if (httpResponse.getEntity() != null) {
					result = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
				}
			}
		} finally {
			// 释放资源
			release(httpResponse, httpClient);
		}

		return result;
	}

	/**
	 * 发送post请求；不带请求头和请求参数
	 *
	 * @param url 请求地址
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String url) throws Exception {
		return doPost(url, null);
	}

	/**
	 * 发送post请求；带请求参数
	 *
	 * @param url    请求地址
	 * @param params 参数集合
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String url, Map<String, Object> params) throws Exception {
		return doPost(url, null, params);
	}

	/**
	 * 发送post请求；带请求头和请求参数
	 *
	 * @param url     请求地址
	 * @param headers 请求头集合
	 * @param params  请求参数集合
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String url, Map<String, String> headers, Map<String, Object> params) throws Exception {
		// 创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 创建http对象
		HttpPost httpPost = new HttpPost(url);
		/**
		 * setConnectTimeout：设置连接超时时间，单位毫秒。
		 * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
		 * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
		 * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
		 */
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
		httpPost.setConfig(requestConfig);
		// 设置请求头
        /*httpPost.setHeader("Cookie", "");
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");*/
		packageHeader(headers, httpPost);

		// 封装请求参数
		packageParam(params, httpPost);

		// 创建httpResponse对象
		CloseableHttpResponse httpResponse = null;

		String result = "";
		try {

			// 执行请求
			httpResponse = httpClient.execute(httpPost);

			// 获取返回结果
			if (httpResponse != null && httpResponse.getStatusLine() != null) {
				if (httpResponse.getEntity() != null) {
					result = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
				}
			}

		} finally {
			// 释放资源
			release(httpResponse, httpClient);
		}
		return result;
	}


	/**
	 * @Title:POST请求
	 * @Decription:发送POST请求，data参数只支持JSON对象（com.alibaba.fastjson.JSONObject）
	 * @param url  请求地址
	 * @param data 只支持JSON对象（com.alibaba.fastjson.JSONObject）
	 * @return String
	 */
	public static String sendPost(String url, JSONObject data) throws IOException {
		// 设置默认请求头
		Map<String, String> headers = new HashMap<>();
		headers.put("content-type", "application/json");

		return doPostByJSON(url, headers, data, ENCODING);
	}

	/**
	 * @Title:POST请求
	 * @param url    请求地址
	 * @param params Map集合(输入参数要求为JSON对象)
	 * @return String
	 */
	public static String sendPost(String url, Map<String, Object> params) throws IOException {
		// 设置默认请求头
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		// 将map转成json
		JSONObject data = JSONObject.parseObject(JSON.toJSONString(params));
		return doPostByJSON(url, headers, data, ENCODING);
	}

	/**
	 * @Title POST请求
	 * @param url     请求地址
	 * @param headers Map集合的请求头信息
	 * @param data    只支持JSON对象（com.alibaba.fastjson.JSONObject）
	 * @return String
	 */
	public static String sendPost(String url, Map<String, String> headers, JSONObject data) throws IOException {
		return doPostByJSON(url, headers, data, ENCODING);
	}


	/**
	 * @Title POST请求（默认编码：UTF-8）
	 * @param url     请求地址
	 * @param headers Map集合的请求头参数
	 * @param params  Map集合(输入参数为JSON对象)
	 * @return String
	 */
	public static String sendPost(String url, Map<String, String> headers, Map<String, String> params) throws IOException {
		// 将map转成json
		JSONObject data = JSONObject.parseObject(JSON.toJSONString(params));
		return doPostByJSON(url, headers, data, ENCODING);
	}

	/**
	 * @Title: sendPost
	 * @Description: TODO(发送post请求)
	 * @author
	 * @date 2018年5月10日 下午4:36:17
	 * @param url      请求地址
	 * @param headers  请求头
	 * @param data     请求实体
	 * @param encoding 字符集
	 * @return String
	 * @throws IOException
	 */
	private static String doPostByJSON(String url, Map<String, String> headers, JSONObject data, String encoding) throws IOException {
		// 请求返回结果
		String resultJson = null;
		// 创建Client
		CloseableHttpClient client = HttpClients.createDefault();
		// 发送请求,返回响应对象
		CloseableHttpResponse response = null;
		// 创建HttpPost对象
		HttpPost httpPost = new HttpPost();

		/**
		 * setConnectTimeout：设置连接超时时间，单位毫秒。
		 * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
		 * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
		 * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。
		 * 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
		 */
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
		httpPost.setConfig(requestConfig);

		try {
			// 设置请求地址
			httpPost.setURI(new URI(url));
			// 设置请求头
			packageHeader(headers, httpPost);

			// 设置实体
			httpPost.setEntity(new StringEntity(JSON.toJSONString(data)));
			// 发送请求,返回响应对象
			response = client.execute(httpPost);
			// 获取响应状态
			int status = response.getStatusLine().getStatusCode();

			if (status != HttpStatus.SC_OK) {
				System.out.println("响应失败，状态码：" + status);
			}
			// 获取响应结果
			resultJson = EntityUtils.toString(response.getEntity(), encoding);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release(response, client);
		}
		return resultJson;
	}

	/**
	 * POST请求xml参数
	 * @param url
	 * @param requestDataXml
	 * @return String
	 */
	public static String doPostByXml(String url, String requestDataXml) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String result = "";

		try {
			//创建httpClient实例
			httpClient = HttpClients.createDefault();
			//创建httpPost远程连接实例
			HttpPost httpPost = new HttpPost(url);
			//配置请求参数实例
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(35000)//设置连接主机服务超时时间
					.setConnectionRequestTimeout(35000)//设置连接请求超时时间
					.setSocketTimeout(60000)//设置读取数据连接超时时间
					.build();
			//为httpPost实例设置配置
			httpPost.setConfig(requestConfig);
			//设置请求参数
			httpPost.setEntity(new StringEntity(requestDataXml,"UTF-8"));
			//设置请求头内容
			httpPost.addHeader("Content-Type","text/xml");

			//执行post请求得到返回对象
			response = httpClient.execute(httpPost);
			//通过返回对象获取数据
			HttpEntity entity = response.getEntity();
			//将返回的数据转换为字符串
			result = EntityUtils.toString(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}


	/**
	 * Description: 封装请求头
	 *
	 * @param params
	 * @param httpMethod
	 */
	public static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
		// 封装请求头
		if (params != null) {
			Set<Map.Entry<String, String>> entrySet = params.entrySet();
			for (Map.Entry<String, String> entry : entrySet) {
				// 设置到请求头到HttpRequestBase对象中
				System.out.println(entry.getKey() + ": " + entry.getValue());
				httpMethod.setHeader(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * Description: 封装请求参数
	 *
	 * @param params
	 * @param httpMethod
	 * @throws UnsupportedEncodingException
	 */
	public static void packageParam(Map<String, Object> params, HttpEntityEnclosingRequestBase httpMethod)
			throws UnsupportedEncodingException {
		// 封装请求参数
		if (null != params && params.size() > 0) {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			Set<Map.Entry<String, Object>> entrySet = params.entrySet();
			for (Map.Entry<String, Object> entry : entrySet) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
			}

			// 设置到请求的http对象中
			httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
		}
	}




	/**
	 * @Title: sendGet
	 * @Description: TODO(发送get请求)
	 * @author
	 * @date 2018年5月14日 下午2:39:01
	 * @param url      请求地址
	 * @param params   请求参数
	 * @param encoding 编码
	 * @return String
	 * @throws IOException
	 */
	public static String sendGet(String url, Map<String, Object> params, String encoding) throws IOException {
		// 请求结果
		String resultJson = null;
		// 创建client
		CloseableHttpClient client = HttpClients.createDefault();
		//响应对象
		CloseableHttpResponse response = null;
		// 创建HttpGet
		HttpGet httpGet = new HttpGet();
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			// 封装参数
			if (params != null) {
				for (String key : params.keySet()) {
					builder.addParameter(key, params.get(key).toString());
				}
			}
			URI uri = builder.build();
			// 设置请求地址
			httpGet.setURI(uri);

			//设置配置请求参数
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(35000)//连接主机服务超时时间
					.setConnectionRequestTimeout(35000)//请求超时时间
					.setSocketTimeout(60000)//数据读取超时时间
					.build();

			// 发送请求，返回响应对象
			response = client.execute(httpGet);
			// 获取响应状态
			int status = response.getStatusLine().getStatusCode();

			if (status != HttpStatus.SC_OK) {
				System.out.println("响应失败，状态码：" + status);
			}

			// 获取响应数据
			resultJson = EntityUtils.toString(response.getEntity(), encoding);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			release(response, client);
		}
		return resultJson;
	}


	/**
	 * Description: 释放资源
	 *
	 * @param httpResponse
	 * @param httpClient
	 * @throws IOException
	 */
	public static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) throws IOException {
		// 释放资源
		if (httpResponse != null) {
			httpResponse.close();
		}
		if (httpClient != null) {
			httpClient.close();
		}
	}

	/**
	 *
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 */
	public static String sendPara(String url, Map<String, Object> params, Map<String, String> headers, String type) {

		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();

		for (Map.Entry<String, Object> param : params.entrySet()) {

			if(param.getValue() instanceof File) {
				//System.out.println("上传文件" + param.getKey() + ((TransformationBean) param.getValue()).getFileByte());
				multipartEntityBuilder.addBinaryBody("avatars[]", (File) param.getValue());

			} else if(param.getValue() instanceof String) {
				System.out.println(param.getKey() + ":" + param.getValue());

				multipartEntityBuilder.addTextBody(param.getKey(), (String) param.getValue() , ContentType.APPLICATION_JSON);
			}
		}

		multipartEntityBuilder.setContentType(ContentType.MULTIPART_FORM_DATA);
		multipartEntityBuilder.setCharset(Charset.defaultCharset());
		HttpEntity reqEntity = multipartEntityBuilder.build();

		HttpPost httpPost = new HttpPost(url);


		//设置配置请求参数
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(35000)//连接主机服务超时时间
				.setConnectionRequestTimeout(35000)//请求超时时间
				.setSocketTimeout(60000)//数据读取超时时间
				.build();

		httpPost.setConfig(requestConfig);

		if(headers != null && headers.size() != 0) {
			packageHeader(headers, httpPost);
		}

		String respContent = null;
		CloseableHttpClient _httpClient = null;
		CloseableHttpResponse resp = null;
		try {
			httpPost.setEntity(reqEntity);
			_httpClient = HttpClientBuilder.create().build();
			resp = _httpClient.execute(httpPost);
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭资源
				release(resp, _httpClient);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return respContent;
	}


	/**
	 * post请求
	 * @param url
	 * @param json
	 * @return
	 */
	public static String doPost(String url,JSONObject json,Map<String, String> headers) {
		CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
			httpPost = new HttpPost(url);
			StringEntity s = null;
			if(null != json) {
				s = new StringEntity(json.toString(),"UTF-8");
			} else {
				s = new StringEntity("");
			}

			s.setContentEncoding("UTF-8");
			s.setContentType("application/x-www-form-urlencoded");//发送json数据需要设置contentType
			httpPost.setEntity(s);

			if(headers != null && headers.size() != 0) {
				packageHeader(headers, httpPost);
			}

			CloseableHttpResponse execute = httpClient.execute(httpPost);

			result = EntityUtils.toString(execute.getEntity());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * 保存Header头
	 * @param httpPost
	 * @param httpGet
	 * @param headers
	 */
	public static void packageHeader(HttpPost httpPost, HttpGet httpGet,String... headers) {
		if(headers != null && headers.length > 0) {
			for (int i = 0; i < headers.length; i++) {
				String[] split = headers[i].split(":");
				if(httpPost != null) {
					httpPost.setHeader(split[0], split[1]);
				} else if(httpGet != null) {
					httpGet.setHeader(split[0], split[1]);
				}

			}
		}
	}

	/**
	 * @Title: sendPUTCHPara
	 * @Description: PUTCH请求
	 * @param: @param string
	 * @param: @param paramMap
	 * @param: @param headers
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public static String sendPUTCHPara(String url, Map<String, Object> params, Map<String, String> headers) {


		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();

		for (Map.Entry<String, Object> param : params.entrySet()) {

			//
			if(param.getValue() instanceof File) {
				//System.out.println("上传文件" + param.getKey() + ((TransformationBean) param.getValue()).getFileByte());
				multipartEntityBuilder.addBinaryBody(param.getKey(), (File) param.getValue());

			} else if(param.getValue() instanceof String) {
				System.out.println(param.getKey() + ":" + param.getValue());
				multipartEntityBuilder.addTextBody(param.getKey(), (String) param.getValue(), ContentType.APPLICATION_JSON);
			}
		}
		multipartEntityBuilder.setContentType(ContentType.MULTIPART_FORM_DATA);

		HttpEntity reqEntity = multipartEntityBuilder.build();

		HttpPatch httpPost = new HttpPatch(url);

		if(headers != null && headers.size() != 0) {
			packageHeader(headers, httpPost);
		}

		String respContent = null;
		CloseableHttpClient _httpClient = null;
		CloseableHttpResponse resp = null;
		try {
			httpPost.setEntity(reqEntity);
			_httpClient = HttpClientBuilder.create().build();
			resp = _httpClient.execute(httpPost);
			HttpEntity he = resp.getEntity();
			respContent = EntityUtils.toString(he, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			//关闭资源
			try {
				release(resp, _httpClient);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return respContent;
	}
}