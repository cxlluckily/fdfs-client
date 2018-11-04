package com.shankephone.fdfs;


public class FdfsClientTests {

	public static void main(String[] args) {
		String fileId = FdfsClient.upload("D:\\a\\a.jpg", null, null);
		System.out.println(FdfsClient.getDownloadServer() + fileId);
		int downloadStatus = FdfsClient.download(fileId, "D:\\a\\d.png");
		System.out.println(downloadStatus);
		//int deleteStatus = FdfsClient.delete(fileId);
		//System.out.println(deleteStatus);
	}

}
