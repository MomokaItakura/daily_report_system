package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

    /**
     * コンストラクタ
     * @see HttpFilter#HttpFilter()
     */
    public EncodingFilter() {

    }

    /**
     * フィルタの処理が不要になったため、
     * フィルタを破棄するというときの処理を定義
     * @see Filter#destroy()
     */
    public void destroy() {

    }

    /**
     * フィルタとしての実行内容を定義するメソッド
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        /*
         * chain.doFilter(request, response);の
         * 前後のどちらに書くかで動作が変わる
         * 前に書いた処理は、サーブレットが処理を実行する前に
         * フィルタの処理が実行される
         * 後に書いた処理は、サーブレットが処理を実行した後に
         * フィルタの処理が実行される
         */

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }

    /**
     * フィルタの処理がはじめて実行されるときの
     * 処理を定義
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {

    }
}