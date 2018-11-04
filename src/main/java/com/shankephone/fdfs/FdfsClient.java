package com.shankephone.fdfs;

import java.net.URL;

import com.shankephone.fdfs.common.ClassUtils;
import com.shankephone.fdfs.common.FdfsException;
import com.shankephone.fdfs.common.NameValuePair;
import com.shankephone.fdfs.common.SynchronizationManager;
/**
 * FastDFS客户端
 * @author DuXiaohua
 * @version 2015年6月4日 下午4:54:22
 */
public class FdfsClient {

	private static final String CONFIG_FILE_PATH = "fdfs.properties";
	private static final String STORAGECLIENT_THREAD_BIND_NAME = "StorageClient";
	
	static {
		try {
			URL url = ClassUtils.getResource(CONFIG_FILE_PATH);
			ClientGlobal.init(url.getFile());
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	/**
	 * <p>获取下载服务器地址.</p>
	 * <p>下载服务器地址配置在fdfs.properties中,参数名为download_server.</p>
	 * @author DuXiaohua
	 * @date 2015年6月4日 下午4:57:55
	 * @return 下载服务器地址
	 */
	public static String getDownloadServer() {
		return ClientGlobal.g_download_server;
	}
	/**
	 * 上传文件
	 * @author DuXiaohua
	 * @date 2015年6月4日 下午7:39:29
	 * @param localFile 本地文件路径
	 * @param extName 扩展名不包含(.),可为null,为null时取文件名中的扩展名
	 * @param metaList 文件的meta信息,可为null
	 * @return 上传成功:文件id,例如:group1/M00/00/00/ooYBAFVud2KAcsy7AABQr1RMYnA515.jpg.
	 *         上传失败:返回null.
	 * @throws FdfsException
	 */
	public static String upload(String localFile, String extName, NameValuePair[] metaList) throws FdfsException {
		try {
			return getStorageClient().upload_file1(localFile, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}
	/**
	 * 上传文件
	 * @author DuXiaohua
	 * @date 2015年6月4日 下午7:39:29
	 * @param groupName 指定上传的组名,可为null
	 * @param localFile 本地文件路径
	 * @param extName 扩展名不包含(.),可为null,为null时取文件名中的扩展名
	 * @param metaList 文件的meta信息,可为null
	 * @return 上传成功:文件id,例如:group1/M00/00/00/ooYBAFVud2KAcsy7AABQr1RMYnA515.jpg
	 *         上传失败:返回null.
	 * @throws FdfsException
	 */
	public static String upload(String groupName, String localFile, String extName, NameValuePair[] metaList)
			throws FdfsException {
		try {
			return getStorageClient().upload_file1(groupName, localFile, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}
	/**
	 * 上传文件
	 * @author DuXiaohua
	 * @date 2015年6月4日 下午7:39:29
	 * @param fileBuff 文件字节数组
	 * @param extName 扩展名不包含(.)
	 * @param metaList 文件的meta信息,可为null
	 * @return 上传成功:文件id,例如:group1/M00/00/00/ooYBAFVud2KAcsy7AABQr1RMYnA515.jpg
	 *         上传失败:返回null.
	 * @throws FdfsException
	 */
	public static String upload(byte[] fileBuff, String extName, NameValuePair[] metaList) throws FdfsException {
		try {
			return getStorageClient().upload_file1(fileBuff, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String upload(String groupName, byte[] fileBuff, String extName, NameValuePair[] metaList)
			throws FdfsException {
		try {
			return getStorageClient().upload_file1(groupName, fileBuff, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String upload(String groupName, long fileSize, UploadCallback callback, String extName,
			NameValuePair[] metaList) throws FdfsException {
		try {
			return getStorageClient().upload_file1(groupName, fileSize, callback, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String upload(String masterFileId, String prefixName, String localFile, String extName,
			NameValuePair[] metaList) throws FdfsException {
		try {
			return getStorageClient().upload_file1(getFileId(masterFileId), prefixName, localFile, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String upload(String masterFileId, String prefixName, byte[] fileBuff, String extName,
			NameValuePair[] metaList) throws FdfsException {
		try {
			return getStorageClient().upload_file1(getFileId(masterFileId), prefixName, fileBuff, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String upload(String masterFileId, String prefixName, byte[] fileBuff, int offset, int length,
			String extName, NameValuePair[] metaList) throws FdfsException {
		try {
			return getStorageClient().upload_file1(getFileId(masterFileId), prefixName, fileBuff, offset, length, extName,
					metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String upload(String masterFileId, String prefixName, long fileSize, UploadCallback callback,
			String extName, NameValuePair[] metaList) throws FdfsException {
		try {
			return getStorageClient().upload_file1(getFileId(masterFileId), prefixName, fileSize, callback, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String uploadAppender(String localFile, String extName, NameValuePair[] metaList)
			throws FdfsException {
		try {
			return getStorageClient().upload_appender_file1(localFile, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String uploadAppender(String groupName, String localFile, String extName, NameValuePair[] metaList)
			throws FdfsException {
		try {
			return getStorageClient().upload_appender_file1(groupName, localFile, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String uploadAppender(byte[] fileBuff, String extName, NameValuePair[] metaList) throws FdfsException {
		try {
			return getStorageClient().upload_appender_file1(fileBuff, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String uploadAppender(String groupName, byte[] fileBuff, String extName, NameValuePair[] metaList)
			throws FdfsException {
		try {
			return getStorageClient().upload_appender_file1(groupName, fileBuff, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static String uploadAppender(String groupName, long fileSize, UploadCallback callback, String extName,
			NameValuePair[] metaList) throws FdfsException {
		try {
			return getStorageClient().upload_appender_file1(groupName, fileSize, callback, extName, metaList);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int append(String appenderFileId, String localFile) throws FdfsException {
		try {
			return getStorageClient().append_file1(getFileId(appenderFileId), localFile);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int append(String appenderFileId, byte[] fileBuff) throws FdfsException {
		try {
			return getStorageClient().append_file1(getFileId(appenderFileId), fileBuff);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int append(String appenderFileId, byte[] fileBuff, int offset, int length) throws FdfsException {
		try {
			return getStorageClient().append_file1(getFileId(appenderFileId), fileBuff, offset, length);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int append(String appenderFileId, long fileSize, UploadCallback callback) throws FdfsException {
		try {
			return getStorageClient().append_file1(getFileId(appenderFileId), fileSize, callback);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int modify(String appenderFileId, long fileOffset, String localFile) throws FdfsException {
		try {
			return getStorageClient().modify_file1(getFileId(appenderFileId), fileOffset, localFile);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int modify(String appenderFileId, long fileOffset, byte[] fileBuff) throws FdfsException {
		try {
			return getStorageClient().modify_file1(getFileId(appenderFileId), fileOffset, fileBuff);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int modify(String appenderFileId, long fileOffset, byte[] fileBuff, int buffer_offset,
			int bufferLength) throws FdfsException {
		try {
			return getStorageClient().modify_file1(getFileId(appenderFileId), fileOffset, fileBuff, buffer_offset, bufferLength);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int modify(String appenderFileId, long fileOffset, long modify_size, UploadCallback callback)
			throws FdfsException {
		try {
			return getStorageClient().modify_file1(getFileId(appenderFileId), fileOffset, modify_size, callback);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}
	
	/**
	 * 删除文件
	 * @author DuXiaohua
	 * @date 2015年6月8日 上午11:22:18
	 * @param fileId 文件id,例如:group1/M00/00/00/ooYBAFVud2KAcsy7AABQr1RMYnA515.jpg
	 * @return 0-成功;非0-失败
	 * @throws FdfsException
	 */
	public static int delete(String fileId) throws FdfsException {
		try {
			return getStorageClient().delete_file1(getFileId(fileId));
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int truncate(String appenderFileId) throws FdfsException {
		try {
			return getStorageClient().truncate_file1(getFileId(appenderFileId));
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int truncate(String appenderFileId, long truncatedFileSize) throws FdfsException {
		try {
			return getStorageClient().truncate_file1(getFileId(appenderFileId), truncatedFileSize);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}
	/**
	 * 下载文件
	 * @author DuXiaohua
	 * @date 2015年6月8日 上午11:28:38
	 * @param fileId 文件id,例如:group1/M00/00/00/ooYBAFVud2KAcsy7AABQr1RMYnA515.jpg
	 * @return 成功:返回文件字节数组
	 *         失败:返回null
	 * @throws FdfsException
	 */
	public static byte[] download(String fileId) throws FdfsException {
		try {
			return getStorageClient().download_file1(getFileId(fileId));
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}
	/**
	 * 下载文件
	 * @author DuXiaohua
	 * @date 2015年6月8日 上午11:28:38
	 * @param fileId 文件id,例如:group1/M00/00/00/ooYBAFVud2KAcsy7AABQr1RMYnA515.jpg
	 * @param fileOffset 开始下载的偏移量
	 * @param downloadBytes 下载字节数
	 * @return 成功:返回文件字节数组
	 *         失败:返回null
	 * @throws FdfsException
	 */
	public static byte[] download(String fileId, long fileOffset, long downloadBytes) throws FdfsException {
		try {
			return getStorageClient().download_file1(getFileId(fileId), fileOffset, downloadBytes);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}
	/**
	 * 下载文件
	 * @author DuXiaohua
	 * @date 2015年6月8日 上午11:39:35
	 * @param fileId 文件id,例如:group1/M00/00/00/ooYBAFVud2KAcsy7AABQr1RMYnA515.jpg
	 * @param localFile 保存到本地的路径
	 * @return 0-成功;非0-失败
	 * @throws FdfsException
	 */
	public static int download(String fileId, String localFile) throws FdfsException {
		try {
			return getStorageClient().download_file1(getFileId(fileId), localFile);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int download(String fileId, long fileOffset, long downloadBytes, String localFile)
			throws FdfsException {
		try {
			return getStorageClient().download_file1(getFileId(fileId), fileOffset, downloadBytes, localFile);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int download(String fileId, DownloadCallback callback) throws FdfsException {
		try {
			return getStorageClient().download_file1(getFileId(fileId), callback);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int download(String fileId, long fileOffset, long downloadBytes, DownloadCallback callback)
			throws FdfsException {
		try {
			return getStorageClient().download_file1(getFileId(fileId), fileOffset, downloadBytes, callback);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static NameValuePair[] getMetadata(String fileId) throws FdfsException {
		try {
			return getStorageClient().get_metadata1(getFileId(fileId));
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static int setMetadata(String fileId, NameValuePair[] metaList, byte opFlag) throws FdfsException {
		try {
			return getStorageClient().set_metadata1(getFileId(fileId), metaList, opFlag);
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static FileInfo queryFileInfo(String fileId) throws FdfsException {
		try {
			return getStorageClient().query_file_info1(getFileId(fileId));
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}

	public static FileInfo getFileInfo(String fileId) throws FdfsException {
		try {
			return getStorageClient().get_file_info1(getFileId(fileId));
		} catch (Exception e) {
			throw new FdfsException(e);
		}
	}
	
	private static StorageClient1 getStorageClient() {
		StorageClient1 client = (StorageClient1) SynchronizationManager.getResource(STORAGECLIENT_THREAD_BIND_NAME);
		if (client == null) {
			try {
				TrackerClient tracker = new TrackerClient();
				TrackerServer trackerServer = tracker.getConnection();
				if (trackerServer == null) {
					throw new NullPointerException("TrackerServer is null");
				}
				StorageServer storageServer = tracker.getStoreStorage(trackerServer);
				if (storageServer == null) {
					throw new NullPointerException("getStoreStorage fail, error code: " + tracker.getErrorCode());
				}
				client = new StorageClient1(trackerServer, storageServer);
				SynchronizationManager.bindResource(STORAGECLIENT_THREAD_BIND_NAME, client);
			} catch (Exception e) {
				throw new FdfsException(e);
			}
		}
		return client;
	}
	
	public static String getFileId(String url) {
		return url.replaceFirst("^\\A[a-z.+-]+://[^/]*/", "");
	}
		
}
