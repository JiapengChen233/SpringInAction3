<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<body>
<%
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jndi-context.xml");
    DataSource dataSource = (DataSource) ctx.getBean("dataSource");
    Connection connection = dataSource.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("select * from t_article");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
        String articleName = resultSet.getString("article_name");
        System.out.println("articleName: " + articleName);
    }
%>
</body>
</html>
