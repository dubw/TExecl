package bwd.param;

public final class Param {

	private static String srcPathname; // 源文件全路径名,包括文件名和后缀
	private static String destPathname; // 目标文件存放全路径,包括文件名和后缀
	private static String srcSheet1Name; 
	private static String destSheet1Name;
	public static String destSheet2Name;

	//静态默认
	public static int FIRSTROW = 3;
	public static int LASTROW = -2;	// sheet1页面最后有两行无用，要删除

	public static String getSrcPathname() {
		return srcPathname;
	}
	public static void setSrcPathname(String srcPathname) {
		Param.srcPathname = srcPathname;
	}
	public static String getDestPathname() {
		return destPathname;
	}
	public static void setDestPathname(String destPathname) {
		Param.destPathname = destPathname;
	}
	public static String getSrcSheet1Name() {
		return srcSheet1Name;
	}
	public static void setSrcSheet1Name(String srcSheet1Name) {
		Param.srcSheet1Name = srcSheet1Name;
	}
	public static String getDestSheet1Name() {
		return destSheet1Name;
	}
	public static void setDestSheet1Name(String destSheetName) {
		Param.destSheet1Name = destSheetName;
	}
	public static String getDestSheet2Name() {
		return destSheet2Name;
	}
	public static void setDestSheet2Name(String destSheet2Name) {
		Param.destSheet2Name = destSheet2Name;
	}

}
