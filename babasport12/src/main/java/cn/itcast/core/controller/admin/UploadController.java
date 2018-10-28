package cn.itcast.core.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import cn.itcast.common.web.ResponseUtils;
import cn.itcast.core.web.Constants;
import net.fckeditor.response.UploadResponse;

/**
 * 上传图片
 * 商品
 * 品牌
 * 商品介绍 FCK
 * @author ASUS
 *
 */
@Controller
public class UploadController {
	
	//上传图片
	@RequestMapping(value = "/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic,HttpServletResponse response) {
		//从原始名获得扩展名  
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		
		//生成策略
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//这就是图片名称的一部分 用当前时间并精确到毫秒
		String format = df.format(new Date());
		//随机三位数
		Random random = new Random();
		for(int i=0;i<3;i++){
			format += random.nextInt(10);//随机三次的得到的数
		}
		
		//实例化jersey
		Client client = new Client();
		//保存在数据库中的相对路径图片名
		String path ="upload/" + format + "." + ext;
		//另外一台服务器的请求路径
		String url =Constants.IMAGE_URL + path;
		//设置请求路径
		WebResource resource = client.resource(url);
		
		//发送
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回两个路径
		//拼接字符串
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);
		ResponseUtils.renderJson(response, jo.toString());
	}
		//上传fck图片
		@RequestMapping(value="/upload/uploadFck.do")
		public void uploadFck(HttpServletRequest request,HttpServletResponse response){
			//强转request
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
			//得到文件  支持多个
			Map<String, MultipartFile> fileMap = mr.getFileMap();
			//遍历map
			Set<Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
			//增强for循环
			for (Entry<String, MultipartFile> entry : entrySet) {
				//这就拿到上传上来的图片了
				MultipartFile pic = entry.getValue();
				//从原始名获得扩展名  
				String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
				
				//生成策略
				DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				//这就是图片名称的一部分 用当前时间并精确到毫秒
				String format = df.format(new Date());
				//随机三位数
				Random random = new Random();
				for(int i=0;i<3;i++){
					format += random.nextInt(10);//随机三次的得到的数
				}
				
				//实例化jersey
				Client client = new Client();
				//保存在数据库中的相对路径图片名
				String path ="upload/" + format + "." + ext;
				//另外一台服务器的请求路径
				String url =Constants.IMAGE_URL + path;
				//设置请求路径
				WebResource resource = client.resource(url);
				
				//发送
				try {
					resource.put(String.class, pic.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//返回URL即可
				UploadResponse ok = UploadResponse.getOK(url);
				//response 返回对象
				//.print和.write的区别,print是字节流，write是字节流
				try {
					response.getWriter().print(ok);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

}
