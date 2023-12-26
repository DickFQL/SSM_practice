<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>商品列表</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<%--引入jquery控件--%>
<script src="<%=path%>/jquery/jquery-1.7.2.js"></script>


<script >
    $(function (){
        $("[value='商品上架']").click(function (){
            location.href = "<%=path%>/goods/toAdd"
        })

        //全选全不选
        $("#cks").click(function () {
            let checked = this.checked;
            $(".qx").each(function () {
                $(this).prop("checked",checked)
            })
        })

        $("[value = '批量删除']").click(function () {
            if ($(".qx:checked").length > 0){

                if(confirm("是否确定删除？")){
                    let ids = "";
                    $(".qx:checked").each(function () {

                        ids +=","+this.value
                    })
                    ids = ids.substring(1);
                    $.ajax({
                        url:"<%=path%>/goods/deleteGoodsByIds",
                        type:"post",
                        data:{ids:ids},
                        success:function (obj) {
                            if (obj == "true"){
                                alert("删除成功！")
                                location.href="<%=path%>/goods/list"
                            }else{
                                alert("删除失败！")
                            }
                        },
                        dataType:"text"
                    })
                }
            }else {
                alert("轻芝士选择一条数据")

            }
        })

    })

    //将当前页的值传给服务端
    function page(currentPage){
        let likeName = '${likeName}';
        if (likeName != null && likeName != ""){
            location.href = "<%=path%>/goods/list?currentPage=" + currentPage+ "&likeName="+likeName;
        }
        else{
            location.href = "<%=path%>/goods/list?currentPage=" + currentPage;
        }

    }
    //根据id查询商品信息
    function findGoodsById(gid){
        location.href = "<%=path%>/goods/findGoodsById?gid=" + gid;
    }
    // 模糊查询

</script>
<body>
<h1 align="center">商品列表</h1>

<form method="post" action="<%=path%>/goods/list">
    <input type="text" placeholder="根据姓名模糊查询" name="likeName" id="likeName" value="${likeName}">
    <input type="submit" value="搜索" class="btn btn-info"  >
</form>

<table class="table">

    <tr>
        <td colspan="11" align="center">
            <input type="button" value="商品上架" class="btn btn-info">
            <input type="button" value="批量删除" class="btn btn-info">

        </td>

    </tr>

    <tr>
        <th><input type="checkbox" id="cks"></th>
        <th scope="col">商品名称</th>
        <th scope="col">价格</th>
        <th scope="col">上架时间</th>
        <th scope="col">所属品牌</th>
        <th scope="col">所属分类</th>
        <th scope="col">商品描述</th>
        <th >库存</th>
        <th>操作</th>
    </tr>
    <c:forEach var="goods" items="${goodsList}">
        <tr>
            <th><input type="checkbox" class="qx" value="${goods.gid}"></th>
            <th>${goods.goodsName}</th>
            <th>${goods.price}</th>
            <th>${goods.upTime}</th>
            <th>
                <c:forEach var="brand" items="${brandList}">
                    <c:if test="${brand.bid==goods.brandId}">${brand.brandName}</c:if>
                </c:forEach>
            </th>
            <th>
                <c:forEach var="cate" items="${cateList}">
                    <c:if test="${cate.cid==goods.cateId}">${cate.cateName}</c:if>
                </c:forEach>
            </th>
            <th>${goods.goodsDesc}</th>
            <th>${goods.num}</th>
            <td>
                <input type="button" class="btn btn-warning" value="编辑" onclick="findGoodsById(${goods.gid})">
                <input type="button" class="btn btn-warning" value="删除" onclick="">
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="11" align="center">
            <a href="#" onclick="page(1)">首页</a>
            <a href="#" onclick="page(${pageUtils.prevPage})">上一页</a>
            <a href="#" onclick="page(${pageUtils.nextPage})">下一页</a>
            <a href="#" onclick="page(${pageUtils.lastPage})">尾页</a>
            当前页：${pageUtils.currentPage}/总页数：${pageUtils.lastPage}
        </td>
    </tr>
</table>
</body>
</html>
