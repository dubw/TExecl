package bwd.interfaces;

public final class Sheet1Param {

	private static String srcPathname = null; // 源文件全路径名,包括文件名和后缀
	private static String destPathname = null; // 目标文件存放全路径,包括文件名和后缀
	private static String srcSheet1Name = "Report"; 
	private static String destSheetName = "out";
	private static int firstrow = 3;
	private static int lastrow = -2;
	private static int firstcolumn = 0;
	private static int lastcolumn = 15;
	/**
	 * @return the srcPathname
	 */
	public static String getSrcPathname() {
		return srcPathname;
	}
	/**
	 * @param srcPathname the srcPathname to set
	 */
	public static void setSrcPathname(String srcPathname) {
		Sheet1Param.srcPathname = srcPathname;
	}
	/**
	 * @return the destPathname
	 */
	public static String getDestPathname() {
		return destPathname;
	}
	/**
	 * @param destPathname the destPathname to set
	 */
	public static void setDestPathname(String destPathname) {
		Sheet1Param.destPathname = destPathname;
	}
	/**
	 * @return the srcSheet1Name
	 */
	public static String getSrcSheet1Name() {
		return srcSheet1Name;
	}
	/**
	 * @param srcSheet1Name the srcSheet1Name to set
	 */
	public static void setSrcSheet1Name(String srcSheet1Name) {
		Sheet1Param.srcSheet1Name = srcSheet1Name;
	}
	/**
	 * @return the destSheetName
	 */
	public static String getDestSheetName() {
		return destSheetName;
	}
	/**
	 * @param destSheetName the destSheetName to set
	 */
	public static void setDestSheetName(String destSheetName) {
		Sheet1Param.destSheetName = destSheetName;
	}
	/**
	 * @return the firstrow
	 */
	public static int getFirstrow() {
		return firstrow;
	}
	/**
	 * @param firstrow the firstrow to set
	 */
	public static void setFirstrow(int firstrow) {
		Sheet1Param.firstrow = firstrow;
	}
	/**
	 * @return the lastrow
	 */
	public static int getLastrow() {
		return lastrow;
	}
	/**
	 * @param lastrow the lastrow to set
	 */
	public static void setLastrow(int lastrow) {
		Sheet1Param.lastrow = lastrow;
	}
	/**
	 * @return the firstcolumn
	 */
	public static int getFirstcolumn() {
		return firstcolumn;
	}
	/**
	 * @param firstcolumn the firstcolumn to set
	 */
	public static void setFirstcolumn(int firstcolumn) {
		Sheet1Param.firstcolumn = firstcolumn;
	}
	/**
	 * @return the lastcolumn
	 */
	public static int getLastcolumn() {
		return lastcolumn;
	}
	/**
	 * @param lastcolumn the lastcolumn to set
	 */
	public static void setLastcolumn(int lastcolumn) {
		Sheet1Param.lastcolumn = lastcolumn;
	}


}
