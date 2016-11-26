function deletePost(idPost){
    $.ajax({
        type: 'get',
        url: '/posts/delete/' + idPost,
        success: function(){
            $('#delete' + idPost).empty();
        }
    });
}

function likes(nameUrl, idPost){
    $.ajax({
        type: 'get',
        url: '/likes/' + nameUrl + '/' + idPost,
        success: function (data) {
            $('#like' + idPost).empty();
            $('#like' + idPost).append(data.length);
        }
    });
}

function allLikes(url, idPost){
    $(document).ready(function(){
        likes(url, idPost);
    });
}