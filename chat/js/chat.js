// declare web socket reference
var socket;

function joinChat() {
    // open socket
    socket = new WebSocket("ws://localhost:7001/websocketchat/chat");
    
    //register function to handle messages recived from server
    socket.onmessage = function (event) {
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

    };
    //register function to handle errors recived from server
    socket.onerror = function (event) {
        //display alert window
        alert(event.data);
    };
    //register function to handle socket closure
    socket.onclose = function (event) {
        //display alert window
        alert("Chat closed");
        
        //clear all messages from the chat
        var chatItem = document.getElementById("chat");
        while (chatItem.hasChildNodes()) {
            chatItem.removeChild(chatItem.lastChild);
        }
        //reset all buttons and fileds
        document.getElementById("join").disabled = false;
        document.getElementById("msg").disabled = true;
        document.getElementById("send").disabled = true;
        document.getElementById("leave").disabled = true;
        document.getElementById("msg").value = "";
    };
    
    // socket is now opened and callback funtions are prepared
    
    //disable join button and enable other buttons and a message field
    document.getElementById("join").disabled = true;
    document.getElementById("msg").disabled = false;
    document.getElementById("send").disabled = false;
    document.getElementById("leave").disabled = false;
}

//This function gets the message filed value, sends it to the server and resets the field
function sendMessage() {
    var message = document.getElementById("msg").value;
    document.getElementById("msg").value = "";
    socket.send(message);
}

//This function performs a notmal socket closure
//Once Socket is closed, an onclose event handler function that was registered for this socket will reset the page and display the alert
function leaveChat() {
    socket.close(1000);
}




