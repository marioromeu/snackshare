package br.com.itads.snackshare.frontend.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Aspecto para verificar a sessão HTTP e saber se o Usuário esá logado	
 * @author marioromeu
 *
 */
@EnableWebMvc
public class SessionInterceptor implements HandlerInterceptor {

	/**
	 * Interception point before the execution of a handler. Called after
	 * HandlerMapping determined an appropriate handler object, but before
	 * HandlerAdapter invokes the handler.
	 * <p>DispatcherServlet processes a handler in an execution chain, consisting
	 * of any number of interceptors, with the handler itself at the end.
	 * With this method, each interceptor can decide to abort the execution chain,
	 * typically sending an HTTP error or writing a custom response.
	 * <p><strong>Note:</strong> special considerations apply for asynchronous
	 * request processing. For more details see
	 * {@link org.springframework.web.servlet.AsyncHandlerInterceptor}.
	 * <p>The default implementation returns {@code true}.
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler chosen handler to execute, for type and/or instance evaluation
	 * @return {@code true} if the execution chain should proceed with the
	 * next interceptor or the handler itself. Else, DispatcherServlet assumes
	 * that this interceptor has already dealt with the response itself.
	 * @throws Exception in case of errors
	 *
	 * Caso o usuário não esteja logado, redireciona pra a tela de login
	 */
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response,
			Object controller) throws Exception {

		boolean returnedValue = isValid(request, response, controller);

		return returnedValue;

	}

	/**
	 * Interception point after successful execution of a handler.
	 * Called after HandlerAdapter actually invoked the handler, but before the
	 * DispatcherServlet renders the view. Can expose additional model objects
	 * to the view via the given ModelAndView.
	 * <p>DispatcherServlet processes a handler in an execution chain, consisting
	 * of any number of interceptors, with the handler itself at the end.
	 * With this method, each interceptor can post-process an execution,
	 * getting applied in inverse order of the execution chain.
	 * <p><strong>Note:</strong> special considerations apply for asynchronous
	 * request processing. For more details see
	 * {@link org.springframework.web.servlet.AsyncHandlerInterceptor}.
	 * <p>The default implementation is empty.
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler the handler (or {@link HandlerMethod}) that started asynchronous
	 * execution, for type and/or instance examination
	 * @param modelAndView the {@code ModelAndView} that the handler returned
	 * (can also be {@code null})
	 * @throws Exception in case of errors
	 */
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {

		System.out.println("Passei aqui");

		//isValid(request, response, null);

	}

	/**
	 * Callback after completion of request processing, that is, after rendering
	 * the view. Will be called on any outcome of handler execution, thus allows
	 * for proper resource cleanup.
	 * <p>Note: Will only be called if this interceptor's {@code preHandle}
	 * method has successfully completed and returned {@code true}!
	 * <p>As with the {@code postHandle} method, the method will be invoked on each
	 * interceptor in the chain in reverse order, so the first interceptor will be
	 * the last to be invoked.
	 * <p><strong>Note:</strong> special considerations apply for asynchronous
	 * request processing. For more details see
	 * {@link org.springframework.web.servlet.AsyncHandlerInterceptor}.
	 * <p>The default implementation is empty.
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler the handler (or {@link HandlerMethod}) that started asynchronous
	 * execution, for type and/or instance examination
	 * @param ex any exception thrown on handler execution, if any; this does not
	 * include exceptions that have been handled through an exception resolver
	 * @throws Exception in case of errors
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {

		System.out.println("Passei aqui");

		//isValid(request, response, null);

	}	

	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	private boolean isValid(
			HttpServletRequest request, 
			HttpServletResponse response,
			Object controller) throws IOException {

		String uri = request.getRequestURI();

		if(uri.contains("resources")) {
			return true;

		} else {
			System.out.println("REQUEST =>> ["+uri+"]");

		}

		if ( uri.equals("/") ){

			response.sendRedirect("/frontend");

		}
		
		/**
		 * Se for URL padrão, não filtra e devolve o TRUE.
		 */
		if (	
				uri.equals("/") ||
				uri.equals("/index") ||
				uri.equals("/login") ||
				uri.equals("/logoff") ||
				uri.equals("/favicon.ico") ||
				uri.equals("/error") ||
				
				uri.equals("/frontend") ||
				uri.equals("/frontend/") ||				
				uri.equals("/frontend/index") ||
				uri.equals("/frontend/login") ||
				uri.equals("/frontend/logoff") ||			
				uri.equals("/frontend/error")
				
			) {

			return true;

			/**
			 * Caso contrário verifica se o usuário está logado.
			 */
		} else {

			if(request.getSession().getAttribute("loggedUser") != null) {
				return true;

			} else {			
				response.sendRedirect("/frontend");

			}

		}

		return false;

	}

}
