<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>商品上架</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>
    <style>
        .back {
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            background-color: #E4E4E4;
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
        .container-round {
            background-color: rgba(255,255,255,0.5);
            width: 736px;
            border-radius: 10px;
            margin-top: 40px
        }
    </style>
</head>

<%--引入jquery控件--%>
<script src="<%=path%>/jquery/jquery-1.7.2.js"></script>

<script>
    $(function(){
        <c:forEach items="${brandList}" var="brand">
        $("select").append("<option value=${brand.bid}>${brand.brandName}</option>")
        </c:forEach>

        $("[value = '添加']").click(function (){
            $.ajax({
                url:"<%=path%>/goods/addGoods",
                type:"post",
                data:$("form").serialize(),
                success:function (obj){
                    if(obj == "1"){
                        alert("您添加的商品已经存在，库存已加一！");
                        location.href = "<%=path%>/goods/list";
                    }else if (obj == "2"){
                        alert("商品不存在，商品已入库");
                        location.href = "<%=path%>/goods/list";
                    }else{
                        alert("后端服务异常，有问题请联系管理员！")
                    }
                },
                dataType:"text"
            })
        })
    })

    function toHome(){
        location.href = "<%=path%>/goods/list";
    }

</script>
<body class="back">

<table class="table table-hover">
</table>

<div class="container container-round">
    <h1 align="center" style="font-size: 30px">商品上架</h1>
    <form class="form-horizontal" role="form" style="margin-top: 20px">
        <div class="form-group">
            <label for="goodsName" class="col-sm-3 control-label">商品名称:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="goodsName">
            </div>
        </div>

        <div class="form-group">
            <label for="price" class="col-sm-3 control-label">价格:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="price" name="price" placeholder="price">
            </div>
        </div>

        <div class="form-group">
            <label for="brandId" class="col-sm-3 control-label">所属品牌:</label>
            <div class="col-sm-6">

                <select id="brandId" class="form-control" name="brandId">
                    <option>---请选择---</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="brandId" class="col-sm-3 control-label">所属分类:</label>
<%--            <div class="col-sm-offset-3 col-sm-6">--%>
                <div class="radio">
                    <label>
                        <input type="radio" name="cateId" value="1"> 家用电器
                    </label>
                    <label>
                        <input type="radio" name="cateId" value="2"> 电子产品
                    </label>
                    <label>
                        <input type="radio" name="cateId" value="3"> 运动器材
                    </label>
                    <label>
                        <input type="radio" name="cateId" value="4"> 服装服饰
                    </label>
                </div>
<%--            </div>--%>
        </div>


        <div class="form-group">
            <label for="goodsDesc" class="col-sm-3 control-label">商品描述:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="goodsDesc" name="goodsDesc" placeholder="goodsDesc">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-6">
                <input type="button" class="btn btn-info" value="添加" >
                <input type="button" class="btn btn-warning" value="取消" onclick="toHome()">
            </div>
        </div>
    </form>
</div>

</body>

</html>

