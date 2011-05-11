package com.gm.common.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

public class DownloadController extends BaseRedirectController {

	private static final Logger logger = Logger.getLogger(DownloadController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String file = request.getParameter("file");
		String filePath = getServletContext().getRealPath(file);
		try {
			downloadFile(filePath, response);
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.info(" File not exists:[" + filePath + "]");
			}
		}
		return null;
	}

	/**
	 * 下载服务器上物理路径文件 Dec 8, 2009,9:26:34 AM
	 * 
	 * @author Azheng
	 * @param path
	 * @param response
	 * @throws IOException
	 */
	public void downloadFile(String path, HttpServletResponse response) throws IOException {
		int i = 65000;
		File file = new File(path);
		String fileName = getFileName(path);
		FileInputStream fileinputstream = new FileInputStream(file);
		long l = file.length();
		int k = 0;
		byte abyte0[] = new byte[i];
		response.setContentLength((int) l);
		response.setContentType("application/octet-stream");// application/x-msdownload
		// attachment --- 作为附件下载
		// inline --- 在线打开
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		while ((long) k < l) {
			int j = fileinputstream.read(abyte0, 0, i);
			k += j;
			response.getOutputStream().write(abyte0, 0, j);
		}
		fileinputstream.close();
		response.flushBuffer();
	}

	private String getFileName(String s) {
		int i = s.lastIndexOf(File.pathSeparator);
		if (i != -1)
			return s.substring(i + 1, s.length());
		else
			return s;
	}

	public void afterPropertiesSet() throws Exception {

	}

}
