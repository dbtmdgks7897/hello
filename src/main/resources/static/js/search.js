var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-naverNews').on('click', function () {
            _this.naverNews();
        });
    },
    save : function () {
        var data = {
            search: $('#search').val()
        };
        $.ajax({
            type: 'POST',
            url: '/api/v1/search',
            dataType: 'json',
            contentType: 'application/json; charset-utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('검색 완료');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    naverNews : function(){
        var data = {
            search: $('#search').val()
        };
        $.ajax({
            type: 'POST',
            url: '/api/v1/news',
            dataType: 'json',
            contentType: 'application/json; charset-utf-8',
            data: JSON.stringify(data)
        }).done(function (data) {
            $("#naverNews").html("");
            $.each(data.items, function(i, field){
                var html = "<a href='" + field.link +"'>" + field.title + "</a><br />";
                $("#naverNews").append(html);
            });
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();