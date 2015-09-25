<%--
  Created by IntelliJ IDEA.
  User: Mang
  Date: 15/9/24
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row" id="content">
  <div class="col-md-10 col-md-offset-1">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4>选择题</h4>
      </div>
      <div class="panel-body">
        <div class="row">
          <div class="col-md-offset-1 col-md-9" id="question"></div>
          <div class="col-md-2">
            <button type="button" class="btn btn-default btn-lg" id="next" aria-label="Left Align">
              <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
            </button>
          </div>
        </div>
        <div class="alert-info alert" role="alert" id="alert-explain" style="display: none;">
        </div>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  var questions, questionId = 0;
  $(document).ready(function() {
    $.getJSON("/question/choice/${urlVariable.libraryId}/offset", function(data) {
      questions = data;
      document.getElementById("question").appendChild(createTemp(data.content[questionId]));
      $('#next').attr("disabled", "disabled");
    });
  });

  $('#next').click(function() {
    $('#question').empty();
    if (questionId++ < 5) {
      $('#next').attr("disabled", "disabled");
      $('#alert-explain').hide();
    }
    $('#question').append(createTemp(questions.content[questionId]));
  });

  $('#question').on('click', '.list-group-item', function() {
    var value = $(this).data('value');
    var question = questions.content[questionId];
    console.log(value, question.answer);

    if(value == question.answer) {
      console.log("this question is true");
      $('#alert-explain').html(question.explain).show();
    } else {
      console.log("this question is error");
      $('#alert-explain').html('<p>正确答案第' + question.answer + '选项</p>'
        + '<p>' + question.explain + '</p>').show();
    }
    $('#next').removeAttr("disabled");
  });

  $('.panel-body').on('mouseenter', '.list-group-item', function() {
    $(this).attr("class", "list-group-item list-group-item-success");
  });

  $('.panel-body').on('mouseleave', '.list-group-item', function() {
    $(this).attr("class", "list-group-item");
  });

  var createTemp = function(question) {
    var outDiv = document.createElement("div");
    outDiv.setAttribute("class", "row");
    outDiv.setAttribute("data-questionId", question.id);

    var h5 = document.createElement("h5");
    h5.innerText = question.question;
    outDiv.appendChild(h5);

    var ul = document.createElement("ul");
    ul.setAttribute("class", "list-group");
    ul.appendChild(createLi('A.\t' + question.a, 1));
    ul.appendChild(createLi('B.\t' + question.b, 2));
    ul.appendChild(createLi('C.\t' + question.c, 3));
    ul.appendChild(createLi('D.\t' + question.d, 4));
    outDiv.appendChild(ul);

    return outDiv;
  };

  var createLi = function(content, value) {
    var li = document.createElement("li");
    li.setAttribute("class", "list-group-item");
    li.setAttribute("data-value", value);
    li.innerText = content;

    return li;
  };
</script>