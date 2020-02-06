/**
 * 提交评论
 */
function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment-content").val();
    comment2target(questionId, 1, content);
}

function comment2target(targetId, type, content) {
    if (!content) {
        alert("Comment cannot be empty , please enter content before submitting !");
        return;
    }
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/comment",
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=001fc6fe2e07b02bac22&redirect_url=http://localhost:8989/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                }
            }
        },
        dataType: "json"
    });
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#reply-" + commentId).val();
    comment2target(commentId, 2, content);
}

/**
 * 展开二级评论
 */
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);
    comments.toggleClass("in");
    console.log(comments.hasClass("in"));
    if (comments.hasClass("in")) {
        e.classList.add("active");
        $.getJSON("/comment/" + id, function (data) {
            var commentBody = $("#comment-body-" + id);
            commentBody.appendChild()
            $.each(data.data, function (comment) {
                $("<div/>", {
                    "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12",
                    html: items.join("")
                })
            });
            $("<div/>", {
                "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse sub-comment",
                "id": "comment-" + id,
                html: items.join("")
            }).appendTo(commentBody);
        });
    } else {
        e.classList.remove("active");
    }
}