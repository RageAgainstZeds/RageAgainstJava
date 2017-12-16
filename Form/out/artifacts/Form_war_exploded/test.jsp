
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Personal data</title>
  </head>
  <body>
    <form action="/save" method="GET">

      <br/> Input yor name <br/><input type="ratio" name="name" value=""/>
      <br/> Input your surname <br/><input type="ratio" name="surname" value=""/>
      <br/> Input your age <br/><input type="ratio" name="age" value=""/>
        <br/><br/><h3>Answer some questions pls.</h3><br/>
      <br/> Red pill or blue pill?
      <br/> <input type="ratio" name="question1" value=""/>
      <br/> Do You like cheese? (yes/no)
      <br/> <input type="ratio" name="question2" value=""/>
      <br/> Are You mad, bro? (yes/no)
      <br/> <input type="ratio" name="question3" value=""/>
      <br/> <input type="submit" />
    </form>
  </body>
</html>
