package ik;

import java.util.List;

import org.apache.http.NameValuePair;

public class APITest {
	 public static void main(String[] args) throws Exception{
		          String url = "http://bank.shihe.site/shihe-bank/app/login";
		          /**
		           * 参数值
		           */
		          Object [] params = new Object[]{"loginId","loginPass"};//,"loginPass","code"
		          /**
		           * 参数名
		           */
		          Object [] values = new Object[]{"autoBinding","hch@123"};
		          /**
		           * 获取参数对象
		           */
		          List<NameValuePair> paramsList = HttpClientService.getParams(params, values);
		          /**
		           * 发送get
		           */
		          Object result = HttpClientService.sendGet(url, paramsList);
		          System.out.println("GET返回信息：" + result);
		          /**
		           * 发送post
		           */
		          //Object result2 = HttpClientService.sendPost(url, paramsList);	  
		          //System.out.println("POST返回信息：" + result2);
		      }
}
