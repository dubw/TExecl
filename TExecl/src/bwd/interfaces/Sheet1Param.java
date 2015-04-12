package bwd.interfaces;

public final class Sheet1Param {

	private static String srcPathname = null; // 源文件全路径名,包括文件名和后缀
	private static String srcSheet1 = "Report"; 
	private static String destPathname = null; // 目标文件存放全路径,包括文件名和后缀
	private static String destSheetname = "out";
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
	 * @return the sheetname
	 */
	public static String getSheetname() {
		return srcSheet1;
	}
	/**
	 * @param sheetname the sheetname to set
	 */
	public static void setSheetname(String sheetname) {
		Sheet1Param.srcSheet1 = sheetname;
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
	public static String getDestSheetname() {
		return destSheetname;
	}
	public static void setDestSheetname(String destSheetname) {
		Sheet1Param.destSheetname = destSheetname;
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
