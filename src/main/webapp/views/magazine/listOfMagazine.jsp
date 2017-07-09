
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery-3.2.1.min.js"></script>

<div class="container">
    <div class="panel">
        <div style="display: flex; justify-content: space-around ">

            <div class="form-group">

                <input type="text" class="form-control" id="magazineName"
                       placeholder="magazine name"/>
            </div>
            <div class="form-group">
                <button class="btn btn-default" id="saveMagazine">save magazine</button>
            </div>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody id="result">
            </tbody>
        </table>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="/js/city.js"></script>
