<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.09.2021
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
</html>
SELECT `admin`.`admin_id`,
`admin`.`admin_login`,
`admin`.`admin_password`
FROM `network_db`.`admin`;
SELECT `message`.`message_id`,
`message`.`from_id`,
`message`.`to_id`,
`message`.`message_content`
FROM `network_db`.`message`;
SELECT `user`.`user_id`,
`user`.`user_name`,
`user`.`user_password`,
`user`.`age`,
`user`.`phone_number`,
`user`.`adress`
FROM `network_db`.`user`;
SELECT `user_to_user`.`user_id`,
`user_to_user`.`user_message_target_id`
FROM `network_db`.`user_to_user`;
