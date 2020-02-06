function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment-content").val();
    if (!content) {
        alert("Comment cannot be empty , please enter content before submitting !");
        return;
    }
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/comment",
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
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