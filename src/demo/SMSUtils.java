//
//package demo;
//import java.util.Random;
//
//import org.apache.log4j.Logger;
//import cn.cuco.httpservice.HttpClientUtils;
// 
///**
// * @ClassName:
// * @Description：
// */
//public class SMSUtils {
// 
//
// 
//	public static boolean sendMessage(String mobile, String identifyCode) {
//		boolean result = false;
//		String userId = "用户名";
//		String password = "密码";
//		String pszMobis = mobile;
//		String pszMsg = "正式完成短信验证" + "【" + identifyCode + "】";// +
//		String iMobiCount = "1";
//		String pszSubPort = "*";
//		String MsgId = RandomStringUtils.randomNumeric(19);
//		try {
//			String url = "请求网关"//
//					+ "userId=" + userId//
//					+ "&password=" + password//
//					+ "&pszMobis=" + pszMobis//
//					+ "&pszMsg=" + pszMsg//
//					+ "&iMobiCount=" + iMobiCount//
//					+ "&pszSubPort=" + pszSubPort//
//					+ "&MsgId=" + MsgId;
// 
//			String responseBody = HttpClientUtils.sendGet(url, null, "UTF-8");
// 
//			if (StringUtils.isNotBlank(responseBody)) {
//				String sub = responseBody.substring(74, responseBody.lastIndexOf("</string>"));
//				System.out.println("截取返回值=================" + sub);
//				if (sub.length() > 15) {// 返回值长度大于15则表示成功
//					result = true;
//					System.out.println("验证码发至{}送成功" + mobile);
//				} else {
//					System.out.println("验证码发至{}失败{}" + mobile + responseBody);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("验证码发至{}异常{}" + mobile + e.getMessage());
// 
//		}
//		return result;
//	}
// 
//	/**
//	 * 产生4位随机数(0000-9999)
//	 * 
//	 * @return 4位随机数
//	 */
//	public static String getFourRandom() {
//		Random random = new Random();
//		String fourRandom = random.nextInt(10000) + "";
//		int randLength = fourRandom.length();
//		if (randLength < 4) {
//			for (int i = 1; i <= 4 - randLength; i++)
//				fourRandom = "0" + fourRandom;
//		}
//		return fourRandom;
//	}
// 
//	public static void main(String[] args) {
//		String mobile = "18333601438";
//		String identifyCode = getFourRandom();
//		SMSUtils.sendMessage(mobile, identifyCode);
//	}
//}