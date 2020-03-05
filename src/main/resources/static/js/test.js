$( document ).ready(function() {

    const wrapper = document.getElementById('myTags');

    wrapper.addEventListener('click', (event) => {
      const isButton = event.target.nodeName === 'BUTTON';
      if (isButton) {
        event.target.classList.toggle("tagEnabled");

        var thumbnails = document.getElementsByClassName("thumbnail");
        var tags = document.getElementsByClassName("tagEnabled");

        for (i = 0; i < thumbnails.length; i++) {
            var isEnabled = false;
            for (j = 0; j < tags.length; j++) {
              console.log(tags.item(j).innerHTML);
              if(thumbnails[i].classList.contains(tags.item(j).innerHTML))
              {
                isEnabled = true
              }
            }

            if(isEnabled == false)
            {
               thumbnails[i].parentElement.style.visibility = 'hidden';
               thumbnails[i].parentElement.style.display = "none";
            }
            else
            {
               thumbnails[i].parentElement.style.visibility = 'visible';
               thumbnails[i].parentElement.style.display = "block";
            }

        }
      }

      console.dir(event.target.id);
    })
 });


// upload file
/* The uploader form */
/*$(function () {
    $(":file").change(function () {
        if (this.files && this.files[0]) {
             var reader = new FileReader();

             reader.onload = imageIsLoaded;
             reader.readAsDataURL(this.files[0]);
        }
    });
});

function imageIsLoaded(e) {
    $('#myImg').attr('src', e.target.result);
};

// Image display

var pics = ["/images/1.png","images/2.png","images/3.jpeg","images/4.jpeg"];

function displayAllImages() {
    for (var i = 1; i < pics.length; i++) {

        var img = new Image();
        img.url = pics[i];
        img.style.width = '160px';
        img.style.height = '120px';

        document.getElementById('images').appendChild(img);
    }
};

$(function() {
    displayAllImages();
});
*/

//var tags = ["tag1", "tag2", "tag3", "tag4", "tag5"];

var tags = [];


function add(tag) {
         var button='<button class="btn btn-secondary tagEnabled">'+tag+'</button>&nbsp;';
         $("#myTags").append(button).append("<br>");
}

window.onload = function iterator() {
  // Upload, tag, and display functions
  //Check File API support
  if(window.File && window.FileList && window.FileReader){
        var filesInput = document.getElementById("files");

        filesInput.addEventListener("change", function(event){

            var files = event.target.files; //FileList object
            var output = document.getElementById("result");

            for(var i = 0; i< files.length; i++)
            {
                var file = files[i];

                //Only pics
                if(!file.type.match('image'))
                  continue;

                var picReader = new FileReader();

                var input = prompt("Please enter meaningful tags in a comma separated list.", "Tag1,Tag2,Tag3,...");

                var newtags = input.split(',');

                 // Generates tags
                 for (var i = 0; i < newtags.length; i++) {

                   tags.push(newtags[i]);
                 }

               // tags.concat(newtags);

                console.log(tags);

                alert(tags);

                 // Generates tags
                 for (var i = 0; i < tags.length; i++) {
                   if (tags.hasOwnProperty(i)) {
                      add(tags[i])
                   }
                 }

                picReader.addEventListener("load",function(event){

                    var picFile = event.target;

                    var div = document.createElement("div");

                    div.innerHTML = "<img class='thumbnail' src='" + picFile.result + "'" +
                            "title='" + picFile.name + "'/>";

                    output.insertBefore(div,null);

                });

                 //Read the image
                picReader.readAsDataURL(file);
            }

        });
  }
  else{
        console.log("Your browser does not support File API");
  }
}