// declare web socket reference
var socket;

function joinChat() {
    name = document.getElementById("name").value;
    if (name == null || name == "") {
        alert("Name required to join chat")
        return;
    }

    socket = new WebSocket("ws://localhost:7001/websocketchat/chat/" + name);

    socket.onmessage = messageReceived;
    socket.onclose = connectionClosed;
    socket.onerror = function (event) {
        alert(event.data);
    }; 

    //disable join button, name field and enable other buttons and a message field
    document.getElementById("name").disabled = true;
    document.getElementById("join").disabled = true;
    document.getElementById("msg").disabled =  false;
    document.getElementById("send").disabled = false;
    document.getElementById("leave").disabled = false;
}

function sendMessage() {
    var message = document.getElementById("msg").value;
    document.getElementById("msg").value = "";
    socket.send(message);
}

function messageReceived(event) {
    //extract messag text
    var message = event.data;

    //dynamically create new html list item containing message text
    var chatElement = document.getElementById("chat");
    var messageElement = document.createElement("div");
    var cssClass = document.createAttribute("class");
    cssClass.value = "chat";
    messageElement.setAttributeNode(cssClass);
    var textItem = document.createTextNode(message);
    messageElement.appendChild(textItem);
    chatElement.appendChild(messageElement);

}

function connectionClosed(event) {
    alert("Chat closed");

    //clear all messages from the chat
    var chatItem = document.getElementById("chat");
    chatItem.innerHTML = ""

    //reset all buttons and fileds
    document.getElementById("name").disabled = false;
    document.getElementById("join").disabled = false;
    document.getElementById("msg").disabled = true;
    document.getElementById("send").disabled = true;
    document.getElementById("leave").disabled = true;
    document.getElementById("msg").value = "";
}

//This function performs a notmal socket closure
//Once Socket is closed, an onclose event handler function will reset the page and display the alert
function leaveChat() {
    socket.close();

}


