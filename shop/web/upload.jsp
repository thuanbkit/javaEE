<%-- 
    Document   : upload
    Created on : Nov 13, 2017, 10:43:18 PM
    Author     : Adminis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload File</title>
    </head>
    <body>
            <center>
        <form method="post" action="UploadServlet" enctype="multipart/form-data">
            Select file to upload:
            <input type="file" name="uploadFile" />
            <br/><br/>
            <input type="submit" value="Upload" />
        </form>
    </center>
    </body>
</html>
