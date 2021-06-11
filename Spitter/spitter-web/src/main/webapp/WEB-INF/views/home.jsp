<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div>
    <h2>
        A global community of friends and strangers spitting out their
        inner-most and personal thoughts on the web for everyone else to see.
    </h2>
    <h3>Look at what these people are spitting right now...</h3>

    <%-- 只有拥有ROLE_SPITTER权限才显示 --%>
    <sec:authorize access="hasRole('ROLE_SPITTER')">
        <ol class="spittle-list">
            <c:forEach var="spittle" items="${spittles}">
                <s:url value="/spitters/{spitterName}" var="spitter_url">
                    <s:param name="spitterName" value="${spittle.spitter.username}"/>
                </s:url>
                <li>
                    <span class="spittleListImage"><img src="<s:url value="/resources/images"/>/spitter_avatar.png" width="48" border="0" align="middle"/></span>
                    <span class="spittleListText">
                        <a href="${spitter_url}"><c:out value="${spittle.spitter.username}"/></a> - <c:out value="${spittle.text}"/><br/>
                        <small><fmt:formatDate value="${spittle.postedTime}" pattern="MM-dd, yyyy"/></small>
                    </span>
                </li>
            </c:forEach>
        </ol>
    </sec:authorize>

    <%-- 只有拥有ROLE_SPITTER权限才显示 --%>
    <sec:authorize url="/sayHello">
        <s:url value="/sayHello" var="hello_url" /><br />
        <a href="${hello_url}">Hello</a>
    </sec:authorize>
</div>
