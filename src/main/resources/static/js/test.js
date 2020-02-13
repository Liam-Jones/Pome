$( document ).ready(function() {
 });
// upload file
$(function() {
   $("#upload").change(function() {
      if (this.files && this.files[0]) {
          for (var i = 0; i < this.files.length; i++) {
            var reader = new FileReader();
            reader.onload = imageIsLoaded;
            reader.readAsDataURL(this.files[i]);
          }
      }
   });
});

function imageIsLoaded(e) {
   $('#myImge').append('<img src=' + e.target.result + '>');
};

/* Tag functions */

var tags = ["tag1", "tag2", "tag3", "tag4", "tag5"];

function add(name, tag) {

  //Create an input type dynamically.
  var element = document.createElement("input");

  //Assign button attributes.
  element.setAttribute("type", "button");
  element.setAttribute("value", tag);
  element.setAttribute("name", name);

  var tag = document.getElementById("myTags");

  //Append the element in page (in span).
  tag.appendChild(element);
  tag.appendChild(document.createElement("br"));
}
window.onload = function iterator() {

  for (var i in tags) {
    if (tags.hasOwnProperty(i)) {
      add(i, tags[i])
    }
  }
}