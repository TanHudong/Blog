#主要介绍一下resources目录
static是spring boot默认的一个扫描的路径，把引用的资源放在这里<br>
bootstrap是样式控制组件<br>
editormd是引入的支持Markdown语法的编辑器<br>
css是全局样式控制<br>
jquery是bootstrap必要的<br>

templates目录下放的是前端的额HTML页面<br>
admin是后台的管理<br>
common是所有页面公用的<br>
front是前台展示的页面<br>




admin/write.html中<br />
通过th:object绑定到Article对象上，<br />然后Spring Boot会自动的帮我们把表单中的数据组合成一个ArtIicle对象

       <form method="post" th:action="@{/admin/save}" th:object="${article}">
           <input name="category" id="cateoryInput" type="hidden" th:field="*{category.name}"/>
           <input type="text" class="form-contorl" palceholder="标题" name="title" th:field="*{title}"/>
           <textarea style="display:none;" name="content" th:field="*{content}"></textarea>
       </form>




#Lombok
在项目中使用Lombok可以减少很多重复代码的书写。比如说getter/setter/toString/equals/hascode等方法的编写 
