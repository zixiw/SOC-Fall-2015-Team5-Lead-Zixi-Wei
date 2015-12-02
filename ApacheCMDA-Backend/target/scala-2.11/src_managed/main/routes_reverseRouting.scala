// @SOURCE:/home/SOC-Fall-2015/ApacheCMDA-Backend/conf/routes
// @HASH:496396369babc0022337446f921de08292c310d8
// @DATE:Wed Dec 02 07:11:35 UTC 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:102
// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:59
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package controllers {

// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
class ReverseNewPostController {


// @LINE:170
def getPostsUnderDomainAndDomainName(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "post/getPostsUnderDomainAndDomainName")
}
                        

// @LINE:163
def addPost(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "post/addPost")
}
                        

// @LINE:167
def deleteTagFromPost(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "post/deleteTagFromPost")
}
                        

// @LINE:165
def addTagToPost(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "post/addTagToPost")
}
                        

// @LINE:169
def getPost(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "post/getPost")
}
                        

// @LINE:164
def addPostToUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "post/addPostToUser")
}
                        

// @LINE:168
def updatePost(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "post/updatePost")
}
                        

// @LINE:166
def deletePost(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "post/deletePost")
}
                        

}
                          

// @LINE:59
class ReverseAssets {


// @LINE:59
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
class ReverseNewInstructionController {


// @LINE:126
def addInstruction(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "instruction/addInstruction")
}
                        

// @LINE:127
def addInstructionToWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "instruction/addInstructionToWorkflow")
}
                        

// @LINE:129
def updateInstruction(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "instruction/updateInstruction")
}
                        

// @LINE:128
def deleteInstruction(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "instruction/deleteInstruction")
}
                        

// @LINE:130
def getInstruction(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "instruction/getInstruction")
}
                        

}
                          

// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
class ReverseNewUserController {


// @LINE:69
def addFriendToUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/addFriendToUser")
}
                        

// @LINE:81
def updateUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/updateUser")
}
                        

// @LINE:84
def getUserIdByEmail(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/getUserIdByEmail")
}
                        

// @LINE:64
def addUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/addUser")
}
                        

// @LINE:66
def addContributorToWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/addContributorToWorkflow")
}
                        

// @LINE:72
def addSubscribeWorkflowToUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/addSubscribeWorkflowToUser")
}
                        

// @LINE:79
def deleteSubscribeGroupFromUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteSubscribeGroupFromUser")
}
                        

// @LINE:74
def deleteUserByUserNameAndPassword(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteUserByUserNameAndPassword")
}
                        

// @LINE:73
def deleteUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteUser")
}
                        

// @LINE:75
def deleteContributorFromWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteContributorFromWorkflow")
}
                        

// @LINE:68
def addUserToGroupAsMember(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/addUserToGroupAsMember")
}
                        

// @LINE:67
def addUserToGroupAsAdmin(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/addUserToGroupAsAdmin")
}
                        

// @LINE:80
def deleteSubscribeWorkflowFromUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteSubscribeWorkflowFromUser")
}
                        

// @LINE:82
def getUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/getUser")
}
                        

// @LINE:83
def getUserIdByUserName(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/getUserIdByUserName")
}
                        

// @LINE:87
def getCollaboratorsNumber(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/getCollaboratorsNumber")
}
                        

// @LINE:70
def addSubscribeUserToUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/addSubscribeUserToUser")
}
                        

// @LINE:71
def addSubscribeGroupToUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/addSubscribeGroupToUser")
}
                        

// @LINE:76
def deleteUserFromGroup(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteUserFromGroup")
}
                        

// @LINE:78
def deleteSubscribeUserFromUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteSubscribeUserFromUser")
}
                        

// @LINE:77
def deleteFriendFromUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteFriendFromUser")
}
                        

// @LINE:85
def getAllUsers(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/getAllUsers")
}
                        

// @LINE:86
def getSubscribersNumber(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/getSubscribersNumber")
}
                        

// @LINE:65
def login(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "user/login")
}
                        

}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
class ReverseInstrumentController {


// @LINE:25
def getAllInstruments(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "instrument/getAllInstruments/json")
}
                        

// @LINE:26
def getInstrument(id:Long): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "instrument/getInstrument/id/" + implicitly[PathBindable[Long]].unbind("id", id) + "/json")
}
                        

// @LINE:27
def addInstrument(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "instrument/addInstrument")
}
                        

// @LINE:28
def updateInstrumentById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "instrument/updateInstrument/id/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:29
def deleteInstrument(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "instrument/deleteInstrument/id/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

}
                          

// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
class ReverseNewOutputController {


// @LINE:123
def getOutput(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "output/getOutput")
}
                        

// @LINE:121
def deleteOutput(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "output/deleteOutput")
}
                        

// @LINE:120
def addOutputToWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "output/addOutputToWorkflow")
}
                        

// @LINE:119
def addOutput(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "output/addOutput")
}
                        

// @LINE:122
def updateOutput(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "output/updateOutput")
}
                        

}
                          

// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
class ReverseNewInputController {


// @LINE:116
def getInput(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "input/getInput")
}
                        

// @LINE:114
def deleteInput(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "input/deleteInput")
}
                        

// @LINE:115
def updateInput(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "input/updateInput")
}
                        

// @LINE:112
def addInput(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "input/addInput")
}
                        

// @LINE:113
def addInputToWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "input/addInputToWorkflow")
}
                        

}
                          

// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
class ReverseNewLinkController {


// @LINE:144
def getLink(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "link/getLink")
}
                        

// @LINE:142
def deleteLink(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "link/deleteLink")
}
                        

// @LINE:141
def addLinkToWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "link/addLinkToWorkflow")
}
                        

// @LINE:143
def updateLink(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "link/updateLink")
}
                        

// @LINE:140
def addLink(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "link/addLink")
}
                        

}
                          

// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
class ReverseNewTaskController {


// @LINE:105
def addTask(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "task/addTask")
}
                        

// @LINE:107
def deleteTask(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "task/deleteTask")
}
                        

// @LINE:108
def updateTask(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "task/updateTask")
}
                        

// @LINE:109
def getTask(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "task/getTask")
}
                        

// @LINE:106
def addTaskToWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "task/addTaskToWorkflow")
}
                        

}
                          

// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseUserController {


// @LINE:50
def addUser(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "users/add")
}
                        

// @LINE:49
def getUser(id:Long): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "users/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:51
def updateUser(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "users/update/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:53
def getAllUsers(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "users/getAllUsers/json")
}
                        

// @LINE:55
def isEmailExisted(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "users/isEmailExisted")
}
                        

// @LINE:52
def deleteUser(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "users/delete/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:56
def deleteUserByUserNameandPassword(userName:String, password:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "users/delete/userName/" + implicitly[PathBindable[String]].unbind("userName", dynamicString(userName)) + "/password/" + implicitly[PathBindable[String]].unbind("password", dynamicString(password)))
}
                        

// @LINE:54
def isUserValid(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "users/isUserValid")
}
                        

}
                          

// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
class ReverseParameterController {


// @LINE:40
def getAllParameters(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "parameter/getAllParameters/json")
}
                        

// @LINE:42
def getParameterById(id:Long): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "parameter/getParameter/id/" + implicitly[PathBindable[Long]].unbind("id", id) + "/json")
}
                        

// @LINE:44
def updateParameterById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "parameter/updateParameter/id/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:41
def getParameterByName(id:Long, name:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "parameter/getParameter/service/" + implicitly[PathBindable[Long]].unbind("id", id) + "/name/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)) + "/json")
}
                        

// @LINE:45
def updateParameterByName(oldName:String): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "parameter/updateParameter/name/" + implicitly[PathBindable[String]].unbind("oldName", dynamicString(oldName)))
}
                        

// @LINE:46
def deleteParameterByName(id:Long, name:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "parameter/deleteParameter/service/" + implicitly[PathBindable[Long]].unbind("id", id) + "/name/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                        

// @LINE:43
def addParameter(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "parameter/addParameter")
}
                        

}
                          

// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
class ReverseNewTagController {


// @LINE:160
def getAllTags(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tag/getAllTags")
}
                        

// @LINE:156
def deleteTag(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tag/deleteTag")
}
                        

// @LINE:157
def updateTag(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tag/updateTag")
}
                        

// @LINE:155
def addTag(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tag/addTag")
}
                        

// @LINE:159
def getTagIdByName(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tag/getTagIdByName")
}
                        

// @LINE:158
def getTag(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tag/getTag")
}
                        

}
                          

// @LINE:102
// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
class ReverseNewWorkflowController {


// @LINE:91
def addAttributeWorkflowToWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/addAttributeWorkflowToWorkflow")
}
                        

// @LINE:90
def addWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/addWorkflow")
}
                        

// @LINE:94
def deleteAttributeWorkflowFromWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/deleteAttributeWorkflowFromWorkflow")
}
                        

// @LINE:101
def addTagToWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/addTagToWorkflow")
}
                        

// @LINE:102
def deleteTagFromWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/deleteTagFromWorkflow")
}
                        

// @LINE:98
def getAllWorkflows(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/getAllWorkflows")
}
                        

// @LINE:93
def deleteWorkflowByName(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/deleteWorkflowByName")
}
                        

// @LINE:97
def getWorkflowIdByName(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/getWorkflowIdByName")
}
                        

// @LINE:95
def updateWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/updateWorkflow")
}
                        

// @LINE:92
def deleteWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/deleteWorkflow")
}
                        

// @LINE:99
def getWorkflowPopularity(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/getWorkflowPopularity")
}
                        

// @LINE:96
def getWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "workflow/getWorkflow")
}
                        

}
                          

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
class ReverseNewReplyController {


// @LINE:175
def deleteReply(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "reply/deleteReply")
}
                        

// @LINE:173
def addReply(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "reply/addReply")
}
                        

// @LINE:176
def updateReply(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "reply/updateReply")
}
                        

// @LINE:174
def addReplyToPost(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "reply/addReplyToPost")
}
                        

// @LINE:177
def getReply(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "reply/getReply")
}
                        

}
                          

// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
class ReverseNewDatasetController {


// @LINE:136
def updateDataset(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "datasetV2/updateDataset")
}
                        

// @LINE:135
def deleteDataset(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "datasetV2/deleteDataset")
}
                        

// @LINE:137
def getDataset(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "datasetV2/getDataset")
}
                        

// @LINE:133
def addDataset(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "datasetV2/addDataset")
}
                        

// @LINE:134
def addDatasetToWorkflow(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "datasetV2/addDatasetToWorkflow")
}
                        

}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
class ReverseDatasetController {


// @LINE:33
def getDataset(id:Long): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "dataset/getDataset/id/" + implicitly[PathBindable[Long]].unbind("id", id) + "/json")
}
                        

// @LINE:32
def getAllDatasets(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "dataset/getAllDatasets/json")
}
                        

// @LINE:37
def queryDatasets(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "dataset/queryDataset")
}
                        

// @LINE:36
def deleteDataset(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "dataset/deleteDataset/id/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:34
def addDataset(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "dataset/addDataset")
}
                        

// @LINE:35
def updateDatasetById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "dataset/updateDataset/id/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseClimateServiceController {


// @LINE:13
def getAllClimateServicesOrderByCreateTime(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "climateService/getAllMostRecentClimateServicesByCreateTime/json")
}
                        

// @LINE:21
def deleteClimateServiceById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "climateService/deleteClimateService/id/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:15
def getAllClimateServicesOrderByCount(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "climateService/getAllMostUsedClimateServices/json")
}
                        

// @LINE:18
def addServiceEntry(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "climateService/addServiceEntry")
}
                        

// @LINE:16
def addClimateService(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "climateService/addClimateService")
}
                        

// @LINE:12
def getAllClimateServices(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "climateService/getAllClimateServices/json")
}
                        

// @LINE:10
def getClimateService(name:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "climateService/getClimateService/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)) + "/json")
}
                        

// @LINE:19
def updateClimateServiceById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "climateService/updateClimateService/id/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:11
def getClimateServiceById(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "climateService/getClimateService/id/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:14
def getAllClimateServicesOrderByLatestAccessTime(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "climateService/getAllMostRecentClimateServicesByLatestAccessTime/json")
}
                        

// @LINE:17
def getAllServiceEntries(): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("format", "json")))
   Call("GET", _prefix + { _defaultPrefix } + "climateService/getAllServiceEntries/json")
}
                        

// @LINE:20
def updateClimateServiceByName(oldName:String): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "climateService/updateClimateService/name/" + implicitly[PathBindable[String]].unbind("oldName", dynamicString(oldName)))
}
                        

// @LINE:22
def deleteClimateServiceByName(name:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "climateService/deleteClimateService/name/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                        

}
                          

// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
class ReverseNewGroupController {


// @LINE:147
def addGroup(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "group/addGroup")
}
                        

// @LINE:151
def getGroupIdByName(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "group/getGroupIdByName")
}
                        

// @LINE:150
def getGroup(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "group/getGroup")
}
                        

// @LINE:149
def updateGroup(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "group/updateGroup")
}
                        

// @LINE:148
def deleteGroup(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "group/deleteGroup")
}
                        

// @LINE:152
def getAllGroups(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "group/getAllGroups")
}
                        

}
                          
}
                  


// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:102
// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:59
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
class ReverseNewPostController {


// @LINE:170
def getPostsUnderDomainAndDomainName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewPostController.getPostsUnderDomainAndDomainName",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getPostsUnderDomainAndDomainName"})
      }
   """
)
                        

// @LINE:163
def addPost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewPostController.addPost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/addPost"})
      }
   """
)
                        

// @LINE:167
def deleteTagFromPost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewPostController.deleteTagFromPost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/deleteTagFromPost"})
      }
   """
)
                        

// @LINE:165
def addTagToPost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewPostController.addTagToPost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/addTagToPost"})
      }
   """
)
                        

// @LINE:169
def getPost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewPostController.getPost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getPost"})
      }
   """
)
                        

// @LINE:164
def addPostToUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewPostController.addPostToUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/addPostToUser"})
      }
   """
)
                        

// @LINE:168
def updatePost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewPostController.updatePost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/updatePost"})
      }
   """
)
                        

// @LINE:166
def deletePost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewPostController.deletePost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/deletePost"})
      }
   """
)
                        

}
              

// @LINE:59
class ReverseAssets {


// @LINE:59
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
class ReverseNewInstructionController {


// @LINE:126
def addInstruction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInstructionController.addInstruction",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "instruction/addInstruction"})
      }
   """
)
                        

// @LINE:127
def addInstructionToWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInstructionController.addInstructionToWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "instruction/addInstructionToWorkflow"})
      }
   """
)
                        

// @LINE:129
def updateInstruction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInstructionController.updateInstruction",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "instruction/updateInstruction"})
      }
   """
)
                        

// @LINE:128
def deleteInstruction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInstructionController.deleteInstruction",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "instruction/deleteInstruction"})
      }
   """
)
                        

// @LINE:130
def getInstruction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInstructionController.getInstruction",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "instruction/getInstruction"})
      }
   """
)
                        

}
              

// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
class ReverseNewUserController {


// @LINE:69
def addFriendToUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.addFriendToUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/addFriendToUser"})
      }
   """
)
                        

// @LINE:81
def updateUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.updateUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/updateUser"})
      }
   """
)
                        

// @LINE:84
def getUserIdByEmail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.getUserIdByEmail",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/getUserIdByEmail"})
      }
   """
)
                        

// @LINE:64
def addUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.addUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/addUser"})
      }
   """
)
                        

// @LINE:66
def addContributorToWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.addContributorToWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/addContributorToWorkflow"})
      }
   """
)
                        

// @LINE:72
def addSubscribeWorkflowToUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.addSubscribeWorkflowToUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/addSubscribeWorkflowToUser"})
      }
   """
)
                        

// @LINE:79
def deleteSubscribeGroupFromUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.deleteSubscribeGroupFromUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteSubscribeGroupFromUser"})
      }
   """
)
                        

// @LINE:74
def deleteUserByUserNameAndPassword : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.deleteUserByUserNameAndPassword",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteUserByUserNameAndPassword"})
      }
   """
)
                        

// @LINE:73
def deleteUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.deleteUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteUser"})
      }
   """
)
                        

// @LINE:75
def deleteContributorFromWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.deleteContributorFromWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteContributorFromWorkflow"})
      }
   """
)
                        

// @LINE:68
def addUserToGroupAsMember : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.addUserToGroupAsMember",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/addUserToGroupAsMember"})
      }
   """
)
                        

// @LINE:67
def addUserToGroupAsAdmin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.addUserToGroupAsAdmin",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/addUserToGroupAsAdmin"})
      }
   """
)
                        

// @LINE:80
def deleteSubscribeWorkflowFromUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.deleteSubscribeWorkflowFromUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteSubscribeWorkflowFromUser"})
      }
   """
)
                        

// @LINE:82
def getUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.getUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/getUser"})
      }
   """
)
                        

// @LINE:83
def getUserIdByUserName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.getUserIdByUserName",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/getUserIdByUserName"})
      }
   """
)
                        

// @LINE:87
def getCollaboratorsNumber : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.getCollaboratorsNumber",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/getCollaboratorsNumber"})
      }
   """
)
                        

// @LINE:70
def addSubscribeUserToUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.addSubscribeUserToUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/addSubscribeUserToUser"})
      }
   """
)
                        

// @LINE:71
def addSubscribeGroupToUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.addSubscribeGroupToUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/addSubscribeGroupToUser"})
      }
   """
)
                        

// @LINE:76
def deleteUserFromGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.deleteUserFromGroup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteUserFromGroup"})
      }
   """
)
                        

// @LINE:78
def deleteSubscribeUserFromUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.deleteSubscribeUserFromUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteSubscribeUserFromUser"})
      }
   """
)
                        

// @LINE:77
def deleteFriendFromUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.deleteFriendFromUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteFriendFromUser"})
      }
   """
)
                        

// @LINE:85
def getAllUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.getAllUsers",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/getAllUsers"})
      }
   """
)
                        

// @LINE:86
def getSubscribersNumber : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.getSubscribersNumber",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/getSubscribersNumber"})
      }
   """
)
                        

// @LINE:65
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewUserController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/login"})
      }
   """
)
                        

}
              

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
class ReverseInstrumentController {


// @LINE:25
def getAllInstruments : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.InstrumentController.getAllInstruments",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "instrument/getAllInstruments/json"})
      }
   """
)
                        

// @LINE:26
def getInstrument : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.InstrumentController.getInstrument",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "instrument/getInstrument/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/json"})
      }
   """
)
                        

// @LINE:27
def addInstrument : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.InstrumentController.addInstrument",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "instrument/addInstrument"})
      }
   """
)
                        

// @LINE:28
def updateInstrumentById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.InstrumentController.updateInstrumentById",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "instrument/updateInstrument/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:29
def deleteInstrument : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.InstrumentController.deleteInstrument",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "instrument/deleteInstrument/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

}
              

// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
class ReverseNewOutputController {


// @LINE:123
def getOutput : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewOutputController.getOutput",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "output/getOutput"})
      }
   """
)
                        

// @LINE:121
def deleteOutput : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewOutputController.deleteOutput",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "output/deleteOutput"})
      }
   """
)
                        

// @LINE:120
def addOutputToWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewOutputController.addOutputToWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "output/addOutputToWorkflow"})
      }
   """
)
                        

// @LINE:119
def addOutput : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewOutputController.addOutput",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "output/addOutput"})
      }
   """
)
                        

// @LINE:122
def updateOutput : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewOutputController.updateOutput",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "output/updateOutput"})
      }
   """
)
                        

}
              

// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
class ReverseNewInputController {


// @LINE:116
def getInput : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInputController.getInput",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "input/getInput"})
      }
   """
)
                        

// @LINE:114
def deleteInput : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInputController.deleteInput",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "input/deleteInput"})
      }
   """
)
                        

// @LINE:115
def updateInput : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInputController.updateInput",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "input/updateInput"})
      }
   """
)
                        

// @LINE:112
def addInput : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInputController.addInput",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "input/addInput"})
      }
   """
)
                        

// @LINE:113
def addInputToWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewInputController.addInputToWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "input/addInputToWorkflow"})
      }
   """
)
                        

}
              

// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
class ReverseNewLinkController {


// @LINE:144
def getLink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewLinkController.getLink",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "link/getLink"})
      }
   """
)
                        

// @LINE:142
def deleteLink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewLinkController.deleteLink",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "link/deleteLink"})
      }
   """
)
                        

// @LINE:141
def addLinkToWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewLinkController.addLinkToWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "link/addLinkToWorkflow"})
      }
   """
)
                        

// @LINE:143
def updateLink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewLinkController.updateLink",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "link/updateLink"})
      }
   """
)
                        

// @LINE:140
def addLink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewLinkController.addLink",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "link/addLink"})
      }
   """
)
                        

}
              

// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
class ReverseNewTaskController {


// @LINE:105
def addTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTaskController.addTask",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "task/addTask"})
      }
   """
)
                        

// @LINE:107
def deleteTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTaskController.deleteTask",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "task/deleteTask"})
      }
   """
)
                        

// @LINE:108
def updateTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTaskController.updateTask",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "task/updateTask"})
      }
   """
)
                        

// @LINE:109
def getTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTaskController.getTask",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "task/getTask"})
      }
   """
)
                        

// @LINE:106
def addTaskToWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTaskController.addTaskToWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "task/addTaskToWorkflow"})
      }
   """
)
                        

}
              

// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseUserController {


// @LINE:50
def addUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.addUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/add"})
      }
   """
)
                        

// @LINE:49
def getUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.getUser",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:51
def updateUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.updateUser",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users/update/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:53
def getAllUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.getAllUsers",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/getAllUsers/json"})
      }
   """
)
                        

// @LINE:55
def isEmailExisted : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.isEmailExisted",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/isEmailExisted"})
      }
   """
)
                        

// @LINE:52
def deleteUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.deleteUser",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "users/delete/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:56
def deleteUserByUserNameandPassword : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.deleteUserByUserNameandPassword",
   """
      function(userName,password) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "users/delete/userName/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userName", encodeURIComponent(userName)) + "/password/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("password", encodeURIComponent(password))})
      }
   """
)
                        

// @LINE:54
def isUserValid : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.isUserValid",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/isUserValid"})
      }
   """
)
                        

}
              

// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
class ReverseParameterController {


// @LINE:40
def getAllParameters : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ParameterController.getAllParameters",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "parameter/getAllParameters/json"})
      }
   """
)
                        

// @LINE:42
def getParameterById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ParameterController.getParameterById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "parameter/getParameter/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/json"})
      }
   """
)
                        

// @LINE:44
def updateParameterById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ParameterController.updateParameterById",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "parameter/updateParameter/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:41
def getParameterByName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ParameterController.getParameterByName",
   """
      function(id,name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "parameter/getParameter/service/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/name/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name)) + "/json"})
      }
   """
)
                        

// @LINE:45
def updateParameterByName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ParameterController.updateParameterByName",
   """
      function(oldName) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "parameter/updateParameter/name/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("oldName", encodeURIComponent(oldName))})
      }
   """
)
                        

// @LINE:46
def deleteParameterByName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ParameterController.deleteParameterByName",
   """
      function(id,name) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "parameter/deleteParameter/service/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/name/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

// @LINE:43
def addParameter : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ParameterController.addParameter",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "parameter/addParameter"})
      }
   """
)
                        

}
              

// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
class ReverseNewTagController {


// @LINE:160
def getAllTags : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTagController.getAllTags",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/getAllTags"})
      }
   """
)
                        

// @LINE:156
def deleteTag : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTagController.deleteTag",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/deleteTag"})
      }
   """
)
                        

// @LINE:157
def updateTag : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTagController.updateTag",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/updateTag"})
      }
   """
)
                        

// @LINE:155
def addTag : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTagController.addTag",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/addTag"})
      }
   """
)
                        

// @LINE:159
def getTagIdByName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTagController.getTagIdByName",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/getTagIdByName"})
      }
   """
)
                        

// @LINE:158
def getTag : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewTagController.getTag",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/getTag"})
      }
   """
)
                        

}
              

// @LINE:102
// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
class ReverseNewWorkflowController {


// @LINE:91
def addAttributeWorkflowToWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.addAttributeWorkflowToWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/addAttributeWorkflowToWorkflow"})
      }
   """
)
                        

// @LINE:90
def addWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.addWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/addWorkflow"})
      }
   """
)
                        

// @LINE:94
def deleteAttributeWorkflowFromWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.deleteAttributeWorkflowFromWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/deleteAttributeWorkflowFromWorkflow"})
      }
   """
)
                        

// @LINE:101
def addTagToWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.addTagToWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/addTagToWorkflow"})
      }
   """
)
                        

// @LINE:102
def deleteTagFromWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.deleteTagFromWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/deleteTagFromWorkflow"})
      }
   """
)
                        

// @LINE:98
def getAllWorkflows : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.getAllWorkflows",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/getAllWorkflows"})
      }
   """
)
                        

// @LINE:93
def deleteWorkflowByName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.deleteWorkflowByName",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/deleteWorkflowByName"})
      }
   """
)
                        

// @LINE:97
def getWorkflowIdByName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.getWorkflowIdByName",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/getWorkflowIdByName"})
      }
   """
)
                        

// @LINE:95
def updateWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.updateWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/updateWorkflow"})
      }
   """
)
                        

// @LINE:92
def deleteWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.deleteWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/deleteWorkflow"})
      }
   """
)
                        

// @LINE:99
def getWorkflowPopularity : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.getWorkflowPopularity",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/getWorkflowPopularity"})
      }
   """
)
                        

// @LINE:96
def getWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewWorkflowController.getWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow/getWorkflow"})
      }
   """
)
                        

}
              

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
class ReverseNewReplyController {


// @LINE:175
def deleteReply : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewReplyController.deleteReply",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reply/deleteReply"})
      }
   """
)
                        

// @LINE:173
def addReply : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewReplyController.addReply",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reply/addReply"})
      }
   """
)
                        

// @LINE:176
def updateReply : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewReplyController.updateReply",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reply/updateReply"})
      }
   """
)
                        

// @LINE:174
def addReplyToPost : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewReplyController.addReplyToPost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reply/addReplyToPost"})
      }
   """
)
                        

// @LINE:177
def getReply : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewReplyController.getReply",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reply/getReply"})
      }
   """
)
                        

}
              

// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
class ReverseNewDatasetController {


// @LINE:136
def updateDataset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewDatasetController.updateDataset",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "datasetV2/updateDataset"})
      }
   """
)
                        

// @LINE:135
def deleteDataset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewDatasetController.deleteDataset",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "datasetV2/deleteDataset"})
      }
   """
)
                        

// @LINE:137
def getDataset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewDatasetController.getDataset",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "datasetV2/getDataset"})
      }
   """
)
                        

// @LINE:133
def addDataset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewDatasetController.addDataset",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "datasetV2/addDataset"})
      }
   """
)
                        

// @LINE:134
def addDatasetToWorkflow : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewDatasetController.addDatasetToWorkflow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "datasetV2/addDatasetToWorkflow"})
      }
   """
)
                        

}
              

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
class ReverseDatasetController {


// @LINE:33
def getDataset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DatasetController.getDataset",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dataset/getDataset/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/json"})
      }
   """
)
                        

// @LINE:32
def getAllDatasets : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DatasetController.getAllDatasets",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dataset/getAllDatasets/json"})
      }
   """
)
                        

// @LINE:37
def queryDatasets : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DatasetController.queryDatasets",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "dataset/queryDataset"})
      }
   """
)
                        

// @LINE:36
def deleteDataset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DatasetController.deleteDataset",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "dataset/deleteDataset/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:34
def addDataset : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DatasetController.addDataset",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "dataset/addDataset"})
      }
   """
)
                        

// @LINE:35
def updateDatasetById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DatasetController.updateDatasetById",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "dataset/updateDataset/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

}
              

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseClimateServiceController {


// @LINE:13
def getAllClimateServicesOrderByCreateTime : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.getAllClimateServicesOrderByCreateTime",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/getAllMostRecentClimateServicesByCreateTime/json"})
      }
   """
)
                        

// @LINE:21
def deleteClimateServiceById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.deleteClimateServiceById",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/deleteClimateService/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:15
def getAllClimateServicesOrderByCount : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.getAllClimateServicesOrderByCount",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/getAllMostUsedClimateServices/json"})
      }
   """
)
                        

// @LINE:18
def addServiceEntry : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.addServiceEntry",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/addServiceEntry"})
      }
   """
)
                        

// @LINE:16
def addClimateService : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.addClimateService",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/addClimateService"})
      }
   """
)
                        

// @LINE:12
def getAllClimateServices : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.getAllClimateServices",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/getAllClimateServices/json"})
      }
   """
)
                        

// @LINE:10
def getClimateService : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.getClimateService",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/getClimateService/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name)) + "/json"})
      }
   """
)
                        

// @LINE:19
def updateClimateServiceById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.updateClimateServiceById",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/updateClimateService/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:11
def getClimateServiceById : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.getClimateServiceById",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/getClimateService/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:14
def getAllClimateServicesOrderByLatestAccessTime : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.getAllClimateServicesOrderByLatestAccessTime",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/getAllMostRecentClimateServicesByLatestAccessTime/json"})
      }
   """
)
                        

// @LINE:17
def getAllServiceEntries : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.getAllServiceEntries",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/getAllServiceEntries/json"})
      }
   """
)
                        

// @LINE:20
def updateClimateServiceByName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.updateClimateServiceByName",
   """
      function(oldName) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/updateClimateService/name/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("oldName", encodeURIComponent(oldName))})
      }
   """
)
                        

// @LINE:22
def deleteClimateServiceByName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ClimateServiceController.deleteClimateServiceByName",
   """
      function(name) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "climateService/deleteClimateService/name/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

}
              

// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
class ReverseNewGroupController {


// @LINE:147
def addGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewGroupController.addGroup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "group/addGroup"})
      }
   """
)
                        

// @LINE:151
def getGroupIdByName : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewGroupController.getGroupIdByName",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "group/getGroupIdByName"})
      }
   """
)
                        

// @LINE:150
def getGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewGroupController.getGroup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "group/getGroup"})
      }
   """
)
                        

// @LINE:149
def updateGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewGroupController.updateGroup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "group/updateGroup"})
      }
   """
)
                        

// @LINE:148
def deleteGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewGroupController.deleteGroup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "group/deleteGroup"})
      }
   """
)
                        

// @LINE:152
def getAllGroups : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NewGroupController.getAllGroups",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "group/getAllGroups"})
      }
   """
)
                        

}
              
}
        


// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:102
// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:59
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package controllers.ref {


// @LINE:170
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:164
// @LINE:163
class ReverseNewPostController {


// @LINE:170
def getPostsUnderDomainAndDomainName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).getPostsUnderDomainAndDomainName(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "getPostsUnderDomainAndDomainName", Seq(), "POST", """""", _prefix + """post/getPostsUnderDomainAndDomainName""")
)
                      

// @LINE:163
def addPost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).addPost(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "addPost", Seq(), "POST", """Post""", _prefix + """post/addPost""")
)
                      

// @LINE:167
def deleteTagFromPost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).deleteTagFromPost(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "deleteTagFromPost", Seq(), "POST", """""", _prefix + """post/deleteTagFromPost""")
)
                      

// @LINE:165
def addTagToPost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).addTagToPost(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "addTagToPost", Seq(), "POST", """""", _prefix + """post/addTagToPost""")
)
                      

// @LINE:169
def getPost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).getPost(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "getPost", Seq(), "POST", """""", _prefix + """post/getPost""")
)
                      

// @LINE:164
def addPostToUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).addPostToUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "addPostToUser", Seq(), "POST", """""", _prefix + """post/addPostToUser""")
)
                      

// @LINE:168
def updatePost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).updatePost(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "updatePost", Seq(), "POST", """""", _prefix + """post/updatePost""")
)
                      

// @LINE:166
def deletePost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).deletePost(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "deletePost", Seq(), "POST", """""", _prefix + """post/deletePost""")
)
                      

}
                          

// @LINE:59
class ReverseAssets {


// @LINE:59
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
class ReverseNewInstructionController {


// @LINE:126
def addInstruction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).addInstruction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "addInstruction", Seq(), "POST", """Instruction""", _prefix + """instruction/addInstruction""")
)
                      

// @LINE:127
def addInstructionToWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).addInstructionToWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "addInstructionToWorkflow", Seq(), "POST", """""", _prefix + """instruction/addInstructionToWorkflow""")
)
                      

// @LINE:129
def updateInstruction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).updateInstruction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "updateInstruction", Seq(), "POST", """""", _prefix + """instruction/updateInstruction""")
)
                      

// @LINE:128
def deleteInstruction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).deleteInstruction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "deleteInstruction", Seq(), "POST", """""", _prefix + """instruction/deleteInstruction""")
)
                      

// @LINE:130
def getInstruction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).getInstruction(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "getInstruction", Seq(), "POST", """""", _prefix + """instruction/getInstruction""")
)
                      

}
                          

// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:80
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
class ReverseNewUserController {


// @LINE:69
def addFriendToUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addFriendToUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addFriendToUser", Seq(), "POST", """""", _prefix + """user/addFriendToUser""")
)
                      

// @LINE:81
def updateUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).updateUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "updateUser", Seq(), "POST", """""", _prefix + """user/updateUser""")
)
                      

// @LINE:84
def getUserIdByEmail(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getUserIdByEmail(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getUserIdByEmail", Seq(), "POST", """""", _prefix + """user/getUserIdByEmail""")
)
                      

// @LINE:64
def addUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addUser", Seq(), "POST", """ User""", _prefix + """user/addUser""")
)
                      

// @LINE:66
def addContributorToWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addContributorToWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addContributorToWorkflow", Seq(), "POST", """""", _prefix + """user/addContributorToWorkflow""")
)
                      

// @LINE:72
def addSubscribeWorkflowToUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addSubscribeWorkflowToUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addSubscribeWorkflowToUser", Seq(), "POST", """""", _prefix + """user/addSubscribeWorkflowToUser""")
)
                      

// @LINE:79
def deleteSubscribeGroupFromUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteSubscribeGroupFromUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteSubscribeGroupFromUser", Seq(), "POST", """""", _prefix + """user/deleteSubscribeGroupFromUser""")
)
                      

// @LINE:74
def deleteUserByUserNameAndPassword(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteUserByUserNameAndPassword(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteUserByUserNameAndPassword", Seq(), "POST", """""", _prefix + """user/deleteUserByUserNameAndPassword""")
)
                      

// @LINE:73
def deleteUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteUser", Seq(), "POST", """""", _prefix + """user/deleteUser""")
)
                      

// @LINE:75
def deleteContributorFromWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteContributorFromWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteContributorFromWorkflow", Seq(), "POST", """""", _prefix + """user/deleteContributorFromWorkflow""")
)
                      

// @LINE:68
def addUserToGroupAsMember(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addUserToGroupAsMember(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addUserToGroupAsMember", Seq(), "POST", """""", _prefix + """user/addUserToGroupAsMember""")
)
                      

// @LINE:67
def addUserToGroupAsAdmin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addUserToGroupAsAdmin(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addUserToGroupAsAdmin", Seq(), "POST", """""", _prefix + """user/addUserToGroupAsAdmin""")
)
                      

// @LINE:80
def deleteSubscribeWorkflowFromUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteSubscribeWorkflowFromUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteSubscribeWorkflowFromUser", Seq(), "POST", """""", _prefix + """user/deleteSubscribeWorkflowFromUser""")
)
                      

// @LINE:82
def getUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getUser", Seq(), "POST", """""", _prefix + """user/getUser""")
)
                      

// @LINE:83
def getUserIdByUserName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getUserIdByUserName(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getUserIdByUserName", Seq(), "POST", """""", _prefix + """user/getUserIdByUserName""")
)
                      

// @LINE:87
def getCollaboratorsNumber(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getCollaboratorsNumber(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getCollaboratorsNumber", Seq(), "POST", """""", _prefix + """user/getCollaboratorsNumber""")
)
                      

// @LINE:70
def addSubscribeUserToUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addSubscribeUserToUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addSubscribeUserToUser", Seq(), "POST", """""", _prefix + """user/addSubscribeUserToUser""")
)
                      

// @LINE:71
def addSubscribeGroupToUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addSubscribeGroupToUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addSubscribeGroupToUser", Seq(), "POST", """""", _prefix + """user/addSubscribeGroupToUser""")
)
                      

// @LINE:76
def deleteUserFromGroup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteUserFromGroup(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteUserFromGroup", Seq(), "POST", """""", _prefix + """user/deleteUserFromGroup""")
)
                      

// @LINE:78
def deleteSubscribeUserFromUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteSubscribeUserFromUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteSubscribeUserFromUser", Seq(), "POST", """""", _prefix + """user/deleteSubscribeUserFromUser""")
)
                      

// @LINE:77
def deleteFriendFromUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteFriendFromUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteFriendFromUser", Seq(), "POST", """""", _prefix + """user/deleteFriendFromUser""")
)
                      

// @LINE:85
def getAllUsers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getAllUsers(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getAllUsers", Seq(), "POST", """""", _prefix + """user/getAllUsers""")
)
                      

// @LINE:86
def getSubscribersNumber(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getSubscribersNumber(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getSubscribersNumber", Seq(), "POST", """""", _prefix + """user/getSubscribersNumber""")
)
                      

// @LINE:65
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "login", Seq(), "POST", """""", _prefix + """user/login""")
)
                      

}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
class ReverseInstrumentController {


// @LINE:25
def getAllInstruments(format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getAllInstruments(format), HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "getAllInstruments", Seq(classOf[String]), "GET", """ Instrument""", _prefix + """instrument/getAllInstruments/json""")
)
                      

// @LINE:26
def getInstrument(id:Long, format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getInstrument(id, format), HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "getInstrument", Seq(classOf[Long], classOf[String]), "GET", """""", _prefix + """instrument/getInstrument/id/$id<[^/]+>/json""")
)
                      

// @LINE:27
def addInstrument(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).addInstrument(), HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "addInstrument", Seq(), "POST", """""", _prefix + """instrument/addInstrument""")
)
                      

// @LINE:28
def updateInstrumentById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).updateInstrumentById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "updateInstrumentById", Seq(classOf[Long]), "PUT", """""", _prefix + """instrument/updateInstrument/id/$id<[^/]+>""")
)
                      

// @LINE:29
def deleteInstrument(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).deleteInstrument(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "deleteInstrument", Seq(classOf[Long]), "DELETE", """""", _prefix + """instrument/deleteInstrument/id/$id<[^/]+>""")
)
                      

}
                          

// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
class ReverseNewOutputController {


// @LINE:123
def getOutput(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).getOutput(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "getOutput", Seq(), "POST", """""", _prefix + """output/getOutput""")
)
                      

// @LINE:121
def deleteOutput(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).deleteOutput(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "deleteOutput", Seq(), "POST", """""", _prefix + """output/deleteOutput""")
)
                      

// @LINE:120
def addOutputToWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).addOutputToWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "addOutputToWorkflow", Seq(), "POST", """""", _prefix + """output/addOutputToWorkflow""")
)
                      

// @LINE:119
def addOutput(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).addOutput(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "addOutput", Seq(), "POST", """Output""", _prefix + """output/addOutput""")
)
                      

// @LINE:122
def updateOutput(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).updateOutput(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "updateOutput", Seq(), "POST", """""", _prefix + """output/updateOutput""")
)
                      

}
                          

// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
class ReverseNewInputController {


// @LINE:116
def getInput(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).getInput(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "getInput", Seq(), "POST", """""", _prefix + """input/getInput""")
)
                      

// @LINE:114
def deleteInput(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).deleteInput(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "deleteInput", Seq(), "POST", """""", _prefix + """input/deleteInput""")
)
                      

// @LINE:115
def updateInput(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).updateInput(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "updateInput", Seq(), "POST", """""", _prefix + """input/updateInput""")
)
                      

// @LINE:112
def addInput(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).addInput(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "addInput", Seq(), "POST", """Input""", _prefix + """input/addInput""")
)
                      

// @LINE:113
def addInputToWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).addInputToWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "addInputToWorkflow", Seq(), "POST", """""", _prefix + """input/addInputToWorkflow""")
)
                      

}
                          

// @LINE:144
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
class ReverseNewLinkController {


// @LINE:144
def getLink(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).getLink(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "getLink", Seq(), "POST", """""", _prefix + """link/getLink""")
)
                      

// @LINE:142
def deleteLink(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).deleteLink(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "deleteLink", Seq(), "POST", """""", _prefix + """link/deleteLink""")
)
                      

// @LINE:141
def addLinkToWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).addLinkToWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "addLinkToWorkflow", Seq(), "POST", """""", _prefix + """link/addLinkToWorkflow""")
)
                      

// @LINE:143
def updateLink(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).updateLink(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "updateLink", Seq(), "POST", """""", _prefix + """link/updateLink""")
)
                      

// @LINE:140
def addLink(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).addLink(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "addLink", Seq(), "POST", """Link""", _prefix + """link/addLink""")
)
                      

}
                          

// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
class ReverseNewTaskController {


// @LINE:105
def addTask(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).addTask(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "addTask", Seq(), "POST", """Task""", _prefix + """task/addTask""")
)
                      

// @LINE:107
def deleteTask(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).deleteTask(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "deleteTask", Seq(), "POST", """""", _prefix + """task/deleteTask""")
)
                      

// @LINE:108
def updateTask(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).updateTask(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "updateTask", Seq(), "POST", """""", _prefix + """task/updateTask""")
)
                      

// @LINE:109
def getTask(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).getTask(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "getTask", Seq(), "POST", """""", _prefix + """task/getTask""")
)
                      

// @LINE:106
def addTaskToWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).addTaskToWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "addTaskToWorkflow", Seq(), "POST", """""", _prefix + """task/addTaskToWorkflow""")
)
                      

}
                          

// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
class ReverseUserController {


// @LINE:50
def addUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).addUser(), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "addUser", Seq(), "POST", """""", _prefix + """users/add""")
)
                      

// @LINE:49
def getUser(id:Long, format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getUser(id, format), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "getUser", Seq(classOf[Long], classOf[String]), "GET", """ Users""", _prefix + """users/$id<[^/]+>""")
)
                      

// @LINE:51
def updateUser(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).updateUser(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "updateUser", Seq(classOf[Long]), "PUT", """""", _prefix + """users/update/$id<[^/]+>""")
)
                      

// @LINE:53
def getAllUsers(format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getAllUsers(format), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "getAllUsers", Seq(classOf[String]), "GET", """""", _prefix + """users/getAllUsers/json""")
)
                      

// @LINE:55
def isEmailExisted(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isEmailExisted(), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "isEmailExisted", Seq(), "POST", """""", _prefix + """users/isEmailExisted""")
)
                      

// @LINE:52
def deleteUser(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUser(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "deleteUser", Seq(classOf[Long]), "DELETE", """""", _prefix + """users/delete/$id<[^/]+>""")
)
                      

// @LINE:56
def deleteUserByUserNameandPassword(userName:String, password:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUserByUserNameandPassword(userName, password), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "deleteUserByUserNameandPassword", Seq(classOf[String], classOf[String]), "DELETE", """""", _prefix + """users/delete/userName/$userName<[^/]+>/password/$password<[^/]+>""")
)
                      

// @LINE:54
def isUserValid(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isUserValid(), HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "isUserValid", Seq(), "POST", """""", _prefix + """users/isUserValid""")
)
                      

}
                          

// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
class ReverseParameterController {


// @LINE:40
def getAllParameters(format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getAllParameters(format), HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "getAllParameters", Seq(classOf[String]), "GET", """ Parameter""", _prefix + """parameter/getAllParameters/json""")
)
                      

// @LINE:42
def getParameterById(id:Long, format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterById(id, format), HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "getParameterById", Seq(classOf[Long], classOf[String]), "GET", """""", _prefix + """parameter/getParameter/id/$id<[^/]+>/json""")
)
                      

// @LINE:44
def updateParameterById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "updateParameterById", Seq(classOf[Long]), "PUT", """""", _prefix + """parameter/updateParameter/id/$id<[^/]+>""")
)
                      

// @LINE:41
def getParameterByName(id:Long, name:String, format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterByName(id, name, format), HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "getParameterByName", Seq(classOf[Long], classOf[String], classOf[String]), "GET", """""", _prefix + """parameter/getParameter/service/$id<[^/]+>/name/$name<[^/]+>/json""")
)
                      

// @LINE:45
def updateParameterByName(oldName:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterByName(oldName), HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "updateParameterByName", Seq(classOf[String]), "PUT", """""", _prefix + """parameter/updateParameter/name/$oldName<[^/]+>""")
)
                      

// @LINE:46
def deleteParameterByName(id:Long, name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).deleteParameterByName(id, name), HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "deleteParameterByName", Seq(classOf[Long], classOf[String]), "DELETE", """""", _prefix + """parameter/deleteParameter/service/$id<[^/]+>/name/$name<[^/]+>""")
)
                      

// @LINE:43
def addParameter(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).addParameter(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "addParameter", Seq(), "POST", """""", _prefix + """parameter/addParameter""")
)
                      

}
                          

// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
class ReverseNewTagController {


// @LINE:160
def getAllTags(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).getAllTags(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "getAllTags", Seq(), "POST", """""", _prefix + """tag/getAllTags""")
)
                      

// @LINE:156
def deleteTag(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).deleteTag(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "deleteTag", Seq(), "POST", """""", _prefix + """tag/deleteTag""")
)
                      

// @LINE:157
def updateTag(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).updateTag(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "updateTag", Seq(), "POST", """""", _prefix + """tag/updateTag""")
)
                      

// @LINE:155
def addTag(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).addTag(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "addTag", Seq(), "POST", """Tag""", _prefix + """tag/addTag""")
)
                      

// @LINE:159
def getTagIdByName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).getTagIdByName(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "getTagIdByName", Seq(), "POST", """""", _prefix + """tag/getTagIdByName""")
)
                      

// @LINE:158
def getTag(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).getTag(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "getTag", Seq(), "POST", """""", _prefix + """tag/getTag""")
)
                      

}
                          

// @LINE:102
// @LINE:101
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
class ReverseNewWorkflowController {


// @LINE:91
def addAttributeWorkflowToWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).addAttributeWorkflowToWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "addAttributeWorkflowToWorkflow", Seq(), "POST", """""", _prefix + """workflow/addAttributeWorkflowToWorkflow""")
)
                      

// @LINE:90
def addWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).addWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "addWorkflow", Seq(), "POST", """Workflow""", _prefix + """workflow/addWorkflow""")
)
                      

// @LINE:94
def deleteAttributeWorkflowFromWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteAttributeWorkflowFromWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "deleteAttributeWorkflowFromWorkflow", Seq(), "POST", """""", _prefix + """workflow/deleteAttributeWorkflowFromWorkflow""")
)
                      

// @LINE:101
def addTagToWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).addTagToWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "addTagToWorkflow", Seq(), "POST", """""", _prefix + """workflow/addTagToWorkflow""")
)
                      

// @LINE:102
def deleteTagFromWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteTagFromWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "deleteTagFromWorkflow", Seq(), "POST", """""", _prefix + """workflow/deleteTagFromWorkflow""")
)
                      

// @LINE:98
def getAllWorkflows(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getAllWorkflows(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "getAllWorkflows", Seq(), "POST", """""", _prefix + """workflow/getAllWorkflows""")
)
                      

// @LINE:93
def deleteWorkflowByName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteWorkflowByName(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "deleteWorkflowByName", Seq(), "POST", """""", _prefix + """workflow/deleteWorkflowByName""")
)
                      

// @LINE:97
def getWorkflowIdByName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getWorkflowIdByName(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "getWorkflowIdByName", Seq(), "POST", """""", _prefix + """workflow/getWorkflowIdByName""")
)
                      

// @LINE:95
def updateWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).updateWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "updateWorkflow", Seq(), "POST", """""", _prefix + """workflow/updateWorkflow""")
)
                      

// @LINE:92
def deleteWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "deleteWorkflow", Seq(), "POST", """""", _prefix + """workflow/deleteWorkflow""")
)
                      

// @LINE:99
def getWorkflowPopularity(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getWorkflowPopularity(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "getWorkflowPopularity", Seq(), "POST", """""", _prefix + """workflow/getWorkflowPopularity""")
)
                      

// @LINE:96
def getWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "getWorkflow", Seq(), "POST", """""", _prefix + """workflow/getWorkflow""")
)
                      

}
                          

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
class ReverseNewReplyController {


// @LINE:175
def deleteReply(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).deleteReply(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "deleteReply", Seq(), "POST", """""", _prefix + """reply/deleteReply""")
)
                      

// @LINE:173
def addReply(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).addReply(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "addReply", Seq(), "POST", """Reply""", _prefix + """reply/addReply""")
)
                      

// @LINE:176
def updateReply(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).updateReply(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "updateReply", Seq(), "POST", """""", _prefix + """reply/updateReply""")
)
                      

// @LINE:174
def addReplyToPost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).addReplyToPost(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "addReplyToPost", Seq(), "POST", """""", _prefix + """reply/addReplyToPost""")
)
                      

// @LINE:177
def getReply(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).getReply(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "getReply", Seq(), "POST", """""", _prefix + """reply/getReply""")
)
                      

}
                          

// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
class ReverseNewDatasetController {


// @LINE:136
def updateDataset(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).updateDataset(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "updateDataset", Seq(), "POST", """""", _prefix + """datasetV2/updateDataset""")
)
                      

// @LINE:135
def deleteDataset(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).deleteDataset(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "deleteDataset", Seq(), "POST", """""", _prefix + """datasetV2/deleteDataset""")
)
                      

// @LINE:137
def getDataset(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).getDataset(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "getDataset", Seq(), "POST", """""", _prefix + """datasetV2/getDataset""")
)
                      

// @LINE:133
def addDataset(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).addDataset(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "addDataset", Seq(), "POST", """Dataset""", _prefix + """datasetV2/addDataset""")
)
                      

// @LINE:134
def addDatasetToWorkflow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).addDatasetToWorkflow(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "addDatasetToWorkflow", Seq(), "POST", """""", _prefix + """datasetV2/addDatasetToWorkflow""")
)
                      

}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
class ReverseDatasetController {


// @LINE:33
def getDataset(id:Long, format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getDataset(id, format), HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "getDataset", Seq(classOf[Long], classOf[String]), "GET", """""", _prefix + """dataset/getDataset/id/$id<[^/]+>/json""")
)
                      

// @LINE:32
def getAllDatasets(format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getAllDatasets(format), HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "getAllDatasets", Seq(classOf[String]), "GET", """ Dataset""", _prefix + """dataset/getAllDatasets/json""")
)
                      

// @LINE:37
def queryDatasets(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).queryDatasets(), HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "queryDatasets", Seq(), "POST", """""", _prefix + """dataset/queryDataset""")
)
                      

// @LINE:36
def deleteDataset(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).deleteDataset(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "deleteDataset", Seq(classOf[Long]), "DELETE", """""", _prefix + """dataset/deleteDataset/id/$id<[^/]+>""")
)
                      

// @LINE:34
def addDataset(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).addDataset(), HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "addDataset", Seq(), "POST", """""", _prefix + """dataset/addDataset""")
)
                      

// @LINE:35
def updateDatasetById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).updateDatasetById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "updateDatasetById", Seq(classOf[Long]), "PUT", """""", _prefix + """dataset/updateDataset/id/$id<[^/]+>""")
)
                      

}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseClimateServiceController {


// @LINE:13
def getAllClimateServicesOrderByCreateTime(format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCreateTime(format), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServicesOrderByCreateTime", Seq(classOf[String]), "GET", """""", _prefix + """climateService/getAllMostRecentClimateServicesByCreateTime/json""")
)
                      

// @LINE:21
def deleteClimateServiceById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "deleteClimateServiceById", Seq(classOf[Long]), "DELETE", """""", _prefix + """climateService/deleteClimateService/id/$id<[^/]+>""")
)
                      

// @LINE:15
def getAllClimateServicesOrderByCount(format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCount(format), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServicesOrderByCount", Seq(classOf[String]), "GET", """""", _prefix + """climateService/getAllMostUsedClimateServices/json""")
)
                      

// @LINE:18
def addServiceEntry(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addServiceEntry(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "addServiceEntry", Seq(), "POST", """""", _prefix + """climateService/addServiceEntry""")
)
                      

// @LINE:16
def addClimateService(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addClimateService(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "addClimateService", Seq(), "POST", """""", _prefix + """climateService/addClimateService""")
)
                      

// @LINE:12
def getAllClimateServices(format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServices(format), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServices", Seq(classOf[String]), "GET", """""", _prefix + """climateService/getAllClimateServices/json""")
)
                      

// @LINE:10
def getClimateService(name:String, format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateService(name, format), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getClimateService", Seq(classOf[String], classOf[String]), "GET", """ Climate Service""", _prefix + """climateService/getClimateService/$name<[^/]+>/json""")
)
                      

// @LINE:19
def updateClimateServiceById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "updateClimateServiceById", Seq(classOf[Long]), "PUT", """""", _prefix + """climateService/updateClimateService/id/$id<[^/]+>""")
)
                      

// @LINE:11
def getClimateServiceById(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateServiceById(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getClimateServiceById", Seq(classOf[Long]), "GET", """""", _prefix + """climateService/getClimateService/id/$id<[^/]+>""")
)
                      

// @LINE:14
def getAllClimateServicesOrderByLatestAccessTime(format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByLatestAccessTime(format), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServicesOrderByLatestAccessTime", Seq(classOf[String]), "GET", """""", _prefix + """climateService/getAllMostRecentClimateServicesByLatestAccessTime/json""")
)
                      

// @LINE:17
def getAllServiceEntries(format:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllServiceEntries(format), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllServiceEntries", Seq(classOf[String]), "GET", """""", _prefix + """climateService/getAllServiceEntries/json""")
)
                      

// @LINE:20
def updateClimateServiceByName(oldName:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceByName(oldName), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "updateClimateServiceByName", Seq(classOf[String]), "PUT", """""", _prefix + """climateService/updateClimateService/name/$oldName<[^/]+>""")
)
                      

// @LINE:22
def deleteClimateServiceByName(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceByName(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "deleteClimateServiceByName", Seq(classOf[String]), "DELETE", """""", _prefix + """climateService/deleteClimateService/name/$name<[^/]+>""")
)
                      

}
                          

// @LINE:152
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
class ReverseNewGroupController {


// @LINE:147
def addGroup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).addGroup(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "addGroup", Seq(), "POST", """Group""", _prefix + """group/addGroup""")
)
                      

// @LINE:151
def getGroupIdByName(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).getGroupIdByName(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "getGroupIdByName", Seq(), "POST", """""", _prefix + """group/getGroupIdByName""")
)
                      

// @LINE:150
def getGroup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).getGroup(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "getGroup", Seq(), "POST", """""", _prefix + """group/getGroup""")
)
                      

// @LINE:149
def updateGroup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).updateGroup(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "updateGroup", Seq(), "POST", """""", _prefix + """group/updateGroup""")
)
                      

// @LINE:148
def deleteGroup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).deleteGroup(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "deleteGroup", Seq(), "POST", """""", _prefix + """group/deleteGroup""")
)
                      

// @LINE:152
def getAllGroups(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).getAllGroups(), HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "getAllGroups", Seq(), "POST", """""", _prefix + """group/getAllGroups""")
)
                      

}
                          
}
        
    