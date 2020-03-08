$( document ).ready(function() {

    const wrapper = document.getElementById('myTags');

    wrapper.addEventListener('click', (event) => {
      const isButton = event.target.nodeName === 'BUTTON';
      if (isButton) {
        event.target.classList.toggle("tagEnabled");
        event.target.classList.toggle("btn-secondary");
        event.target.classList.toggle("btn-info");

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
    });





    var editMode = false;

    const edit = document.getElementById('edit');

    edit.addEventListener('click', event => {
        edit.classList.toggle("btn-default");
        edit.classList.toggle("btn-info");
        edit.classList.toggle("editEnabled");

        if (edit.classList.contains("editEnabled"))
        {
            editMode = true;
        }

        else
        {
            editMode = false;
        }
    });



    const modal = document.getElementById("editModal");
    const result = document.getElementById('result');
    const editImageTags = document.getElementById('editImageTags');
    const submitTags = document.getElementById('submitTags');


    result.addEventListener('click', event => {

        const isImage = event.target.nodeName === 'IMG';

        if (isImage && editMode) {
            var imageTags = event.target.classList;
            event.target.parentElement.classList.toggle("selectedImage");
            editImageTags.defaultValue = imageTags;

            modal.style.display = "block";
        }
    });

    submitTags.onclick = function() {
        var selectedImage = document.getElementsByClassName("selectedImage")[0].getElementsByTagName('img')[0];

        var oldTagsList = [selectedImage.classList][0];
        var newTagsList = editImageTags.value.split(' ');


        for (var i = 0; i< oldTagsList.length; i++)
        {
            var removedTag = String(oldTagsList[i]);
            selectedImage.classList.remove(removedTag);

            var remainingImages = result.getElementsByClassName(removedTag);

            if (remainingImages.length === 0)
            {
                var unusedTag = document.getElementById("myTags").getElementsByClassName(removedTag)[0];

                unusedTag.parentElement.removeChild(unusedTag);
            }
        }

        for (var i = 0; i< newTagsList.length; i++)
        {
            selectedImage.classList.add(newTagsList[i]);
        }

        //selectedImage.getElementsByTagName('img').classList = editImageTags.value;
    }

    document.getElementById('removeImage').onclick = function() {
        var selectedImage = document.getElementsByClassName("selectedImage")[0];

        selectedImage.parentElement.removeChild(selectedImage);
        modal.style.display = "none";
    }

    document.getElementById('close').onclick = function() {
      var selectedImage = document.getElementsByClassName("selectedImage")[0];
      selectedImage.classList.toggle("selectedImage");

      modal.style.display = "none";
    }

    window.onclick = function(event) {
      if (event.target == modal) {
        var selectedImage = document.getElementsByClassName("selectedImage")[0];
        selectedImage.classList.toggle("selectedImage");

        modal.style.display = "none";
      }
    }

 });







function add(tag) {
         var nodeListLength = document.getElementById("myTags").getElementsByClassName(tag).length;
         if(nodeListLength === 0)
         {
             var button = document.createElement("BUTTON");
             button.innerHTML = tag;
             button.classList.add("btn");
             button.classList.add("btn-info");
             button.classList.add("tagEnabled");
             button.classList.add(tag);
             //var button='<button class="btn btn-info tagEnabled">'+tag+'</button>&nbsp;'
             //button.classList.add(tag);
             $("#myTags").append(button).append("<br>");
         }

}

window.onload = function iterator() {
  // Upload, tag, and display functions
  // Check File API support
  if(window.File && window.FileList && window.FileReader){
        var filesInput = document.getElementById("files");


        filesInput.addEventListener("change", function(event){

            var tags = [];

            var files = event.target.files; //FileList object
            var output = document.getElementById("result");

            for(var i = 0; i< files.length; i++)
            {
                var file = files[i];

                // Verifies image is a file type
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
                    div.classList.add("column");
                    div.classList.add("galleryPhoto");

                    var tagsList = "";

                    for (var i = 0; i < tags.length; i++) {
                      if (tags.hasOwnProperty(i)) {
                         div.classList.add(tags[i])
                         tagsList += tags[i] + " "
                      }
                    }

                    //div.prepend($('<img>',{id:'theImg',src:'theImg.png'}))

                    div.innerHTML = "<img class='thumbnail " + tagsList + "'" + "src='" + picFile.result + "'" +
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