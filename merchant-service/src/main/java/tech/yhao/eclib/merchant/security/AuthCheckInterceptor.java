/**
 * 
 */
package tech.yhao.eclib.merchant.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import tech.yhao.eclib.merchant.constant.Constants;

/**
 * @author TaoJn
 *
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {

		String token = httpServletRequest.getHeader(Constants.TOEKN_HEADER);

		if (StringUtils.isEmpty(token)) {
			throw new Exception("Header " + Constants.TOEKN_HEADER + " is missing");
		}

		if (!token.equals(Constants.TOEKN)) {
			throw new Exception("Header  " + Constants.TOEKN_HEADER + " value is incorrect");
		}

		AccessContext.setToken(token);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		AccessContext.clearAccessKey();
	}

}
