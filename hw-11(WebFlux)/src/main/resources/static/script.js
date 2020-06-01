//отоброжение списка книг
    $(function () {
        $.get('/api/book').done(function (books) {
            books.forEach(function (book) {
                $('tbody').append(`
                    <tr>
                        <td>${book.nameBook}</td>
                        <td>${book.author}</td>
                        <td>${book.genre}</td>
                        <td><button id='delete' value=${book.id}>Delete</button></td>
                        <td><button id='edit'value=${book.id}>Edit</button></td>
                    </tr>
                `)
            });
        });
    });

//Обработка нажатия кнопок удаление, редактирования книги
    $( "tbody" ).on('click','button',function() {
       if ($(this).attr('id')=='delete'){
       //Запрос на удаление
       $.ajax({
          url: '/api/book/'+ $(this).val(),
          type: 'DELETE',
       });
       }else{
       //Запрос на редактирование
               event.preventDefault();
               $('#overlay').fadeIn(400, // анимируем показ обложки
                   function(){ // далее показываем мод. окно
                       $('#modal_form')
                           .css('display', 'block')
                           .animate({opacity: 1, top: '50%'}, 200);
               });

               $.get('/api/book/'+$(this).val()).done(function (book) {
                  $('#oldnamebook').val(book.nameBook);
                  $('#buttonsave').click( function(){
                                 var settings = { "url": "/api/book/"+book.id, "method": "PUT", "timeout": 0,
                                          "headers": {"Content-Type": "application/json"},
                                            "data": JSON.stringify({"nameBook": $("#newnamebook").val()})
                                          };

                                          $.ajax(settings).done(function (response) {
                                             console.log(response);
                                          });

                                 });





               });




       }
    });

//Сохранение книги
    $( "#create-user" ).on( "click", function() {
         var settings = { "url": "/api/book", "method": "POST", "timeout": 0,
         "headers": {"Content-Type": "application/json"},
           "data": JSON.stringify({"nameBook": $("#name").val(),"author":$("#author").val(),"genre":$("#genre").val(),"comments":[]}),
         };

         $.ajax(settings).done(function (response) {
            console.log(response);
         });
           location.reload();
    })

        // закрытие модального окна
        $('#modal_close, #overlay').click( function(){
            $('#modal_form')
                .animate({opacity: 0, top: '45%'}, 200,  // уменьшаем прозрачность
                    function(){ // пoсле aнимaции
                        $(this).css('display', 'none'); // скрываем окно
                        $('#overlay').fadeOut(400); // скрывaем пoдлoжку
                    }
                );
        });

