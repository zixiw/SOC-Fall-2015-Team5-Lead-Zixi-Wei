// @SOURCE:/home/SOC-Fall-2015/ApacheCMDA-Backend/conf/routes
// @HASH:496396369babc0022337446f921de08292c310d8
// @DATE:Wed Dec 02 07:11:35 UTC 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:10
private[this] lazy val controllers_ClimateServiceController_getClimateService0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getClimateService/"),DynamicPart("name", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_ClimateServiceController_getClimateService0_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateService(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getClimateService", Seq(classOf[String], classOf[String]),"GET", """ Climate Service""", Routes.prefix + """climateService/getClimateService/$name<[^/]+>/json"""))
        

// @LINE:11
private[this] lazy val controllers_ClimateServiceController_getClimateServiceById1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getClimateService/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_getClimateServiceById1_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateServiceById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getClimateServiceById", Seq(classOf[Long]),"GET", """""", Routes.prefix + """climateService/getClimateService/id/$id<[^/]+>"""))
        

// @LINE:12
private[this] lazy val controllers_ClimateServiceController_getAllClimateServices2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllClimateServices/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllClimateServices2_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServices(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServices", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllClimateServices/json"""))
        

// @LINE:13
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByCreateTime3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllMostRecentClimateServicesByCreateTime/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByCreateTime3_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCreateTime(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServicesOrderByCreateTime", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllMostRecentClimateServicesByCreateTime/json"""))
        

// @LINE:14
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByLatestAccessTime4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllMostRecentClimateServicesByLatestAccessTime/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByLatestAccessTime4_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByLatestAccessTime(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServicesOrderByLatestAccessTime", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllMostRecentClimateServicesByLatestAccessTime/json"""))
        

// @LINE:15
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByCount5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllMostUsedClimateServices/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllClimateServicesOrderByCount5_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCount(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllClimateServicesOrderByCount", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllMostUsedClimateServices/json"""))
        

// @LINE:16
private[this] lazy val controllers_ClimateServiceController_addClimateService6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/addClimateService"))))
private[this] lazy val controllers_ClimateServiceController_addClimateService6_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addClimateService,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "addClimateService", Nil,"POST", """""", Routes.prefix + """climateService/addClimateService"""))
        

// @LINE:17
private[this] lazy val controllers_ClimateServiceController_getAllServiceEntries7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/getAllServiceEntries/json"))))
private[this] lazy val controllers_ClimateServiceController_getAllServiceEntries7_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllServiceEntries(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "getAllServiceEntries", Seq(classOf[String]),"GET", """""", Routes.prefix + """climateService/getAllServiceEntries/json"""))
        

// @LINE:18
private[this] lazy val controllers_ClimateServiceController_addServiceEntry8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/addServiceEntry"))))
private[this] lazy val controllers_ClimateServiceController_addServiceEntry8_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addServiceEntry,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "addServiceEntry", Nil,"POST", """""", Routes.prefix + """climateService/addServiceEntry"""))
        

// @LINE:19
private[this] lazy val controllers_ClimateServiceController_updateClimateServiceById9_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/updateClimateService/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_updateClimateServiceById9_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "updateClimateServiceById", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """climateService/updateClimateService/id/$id<[^/]+>"""))
        

// @LINE:20
private[this] lazy val controllers_ClimateServiceController_updateClimateServiceByName10_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/updateClimateService/name/"),DynamicPart("oldName", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_updateClimateServiceByName10_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceByName(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "updateClimateServiceByName", Seq(classOf[String]),"PUT", """""", Routes.prefix + """climateService/updateClimateService/name/$oldName<[^/]+>"""))
        

// @LINE:21
private[this] lazy val controllers_ClimateServiceController_deleteClimateServiceById11_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/deleteClimateService/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_deleteClimateServiceById11_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "deleteClimateServiceById", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """climateService/deleteClimateService/id/$id<[^/]+>"""))
        

// @LINE:22
private[this] lazy val controllers_ClimateServiceController_deleteClimateServiceByName12_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("climateService/deleteClimateService/name/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_ClimateServiceController_deleteClimateServiceByName12_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceByName(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ClimateServiceController", "deleteClimateServiceByName", Seq(classOf[String]),"DELETE", """""", Routes.prefix + """climateService/deleteClimateService/name/$name<[^/]+>"""))
        

// @LINE:25
private[this] lazy val controllers_InstrumentController_getAllInstruments13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/getAllInstruments/json"))))
private[this] lazy val controllers_InstrumentController_getAllInstruments13_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getAllInstruments(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "getAllInstruments", Seq(classOf[String]),"GET", """ Instrument""", Routes.prefix + """instrument/getAllInstruments/json"""))
        

// @LINE:26
private[this] lazy val controllers_InstrumentController_getInstrument14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/getInstrument/id/"),DynamicPart("id", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_InstrumentController_getInstrument14_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getInstrument(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "getInstrument", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """instrument/getInstrument/id/$id<[^/]+>/json"""))
        

// @LINE:27
private[this] lazy val controllers_InstrumentController_addInstrument15_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/addInstrument"))))
private[this] lazy val controllers_InstrumentController_addInstrument15_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).addInstrument,
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "addInstrument", Nil,"POST", """""", Routes.prefix + """instrument/addInstrument"""))
        

// @LINE:28
private[this] lazy val controllers_InstrumentController_updateInstrumentById16_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/updateInstrument/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_InstrumentController_updateInstrumentById16_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).updateInstrumentById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "updateInstrumentById", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """instrument/updateInstrument/id/$id<[^/]+>"""))
        

// @LINE:29
private[this] lazy val controllers_InstrumentController_deleteInstrument17_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instrument/deleteInstrument/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_InstrumentController_deleteInstrument17_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).deleteInstrument(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.InstrumentController", "deleteInstrument", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """instrument/deleteInstrument/id/$id<[^/]+>"""))
        

// @LINE:32
private[this] lazy val controllers_DatasetController_getAllDatasets18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/getAllDatasets/json"))))
private[this] lazy val controllers_DatasetController_getAllDatasets18_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getAllDatasets(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "getAllDatasets", Seq(classOf[String]),"GET", """ Dataset""", Routes.prefix + """dataset/getAllDatasets/json"""))
        

// @LINE:33
private[this] lazy val controllers_DatasetController_getDataset19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/getDataset/id/"),DynamicPart("id", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_DatasetController_getDataset19_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getDataset(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "getDataset", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """dataset/getDataset/id/$id<[^/]+>/json"""))
        

// @LINE:34
private[this] lazy val controllers_DatasetController_addDataset20_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/addDataset"))))
private[this] lazy val controllers_DatasetController_addDataset20_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).addDataset,
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "addDataset", Nil,"POST", """""", Routes.prefix + """dataset/addDataset"""))
        

// @LINE:35
private[this] lazy val controllers_DatasetController_updateDatasetById21_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/updateDataset/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_DatasetController_updateDatasetById21_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).updateDatasetById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "updateDatasetById", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """dataset/updateDataset/id/$id<[^/]+>"""))
        

// @LINE:36
private[this] lazy val controllers_DatasetController_deleteDataset22_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/deleteDataset/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_DatasetController_deleteDataset22_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).deleteDataset(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "deleteDataset", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """dataset/deleteDataset/id/$id<[^/]+>"""))
        

// @LINE:37
private[this] lazy val controllers_DatasetController_queryDatasets23_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dataset/queryDataset"))))
private[this] lazy val controllers_DatasetController_queryDatasets23_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).queryDatasets,
HandlerDef(this.getClass.getClassLoader, "", "controllers.DatasetController", "queryDatasets", Nil,"POST", """""", Routes.prefix + """dataset/queryDataset"""))
        

// @LINE:40
private[this] lazy val controllers_ParameterController_getAllParameters24_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/getAllParameters/json"))))
private[this] lazy val controllers_ParameterController_getAllParameters24_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getAllParameters(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "getAllParameters", Seq(classOf[String]),"GET", """ Parameter""", Routes.prefix + """parameter/getAllParameters/json"""))
        

// @LINE:41
private[this] lazy val controllers_ParameterController_getParameterByName25_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/getParameter/service/"),DynamicPart("id", """[^/]+""",true),StaticPart("/name/"),DynamicPart("name", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_ParameterController_getParameterByName25_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterByName(fakeValue[Long], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "getParameterByName", Seq(classOf[Long], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """parameter/getParameter/service/$id<[^/]+>/name/$name<[^/]+>/json"""))
        

// @LINE:42
private[this] lazy val controllers_ParameterController_getParameterById26_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/getParameter/id/"),DynamicPart("id", """[^/]+""",true),StaticPart("/json"))))
private[this] lazy val controllers_ParameterController_getParameterById26_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterById(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "getParameterById", Seq(classOf[Long], classOf[String]),"GET", """""", Routes.prefix + """parameter/getParameter/id/$id<[^/]+>/json"""))
        

// @LINE:43
private[this] lazy val controllers_ParameterController_addParameter27_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/addParameter"))))
private[this] lazy val controllers_ParameterController_addParameter27_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).addParameter,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "addParameter", Nil,"POST", """""", Routes.prefix + """parameter/addParameter"""))
        

// @LINE:44
private[this] lazy val controllers_ParameterController_updateParameterById28_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/updateParameter/id/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_ParameterController_updateParameterById28_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterById(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "updateParameterById", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """parameter/updateParameter/id/$id<[^/]+>"""))
        

// @LINE:45
private[this] lazy val controllers_ParameterController_updateParameterByName29_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/updateParameter/name/"),DynamicPart("oldName", """[^/]+""",true))))
private[this] lazy val controllers_ParameterController_updateParameterByName29_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterByName(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "updateParameterByName", Seq(classOf[String]),"PUT", """""", Routes.prefix + """parameter/updateParameter/name/$oldName<[^/]+>"""))
        

// @LINE:46
private[this] lazy val controllers_ParameterController_deleteParameterByName30_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("parameter/deleteParameter/service/"),DynamicPart("id", """[^/]+""",true),StaticPart("/name/"),DynamicPart("name", """[^/]+""",true))))
private[this] lazy val controllers_ParameterController_deleteParameterByName30_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).deleteParameterByName(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ParameterController", "deleteParameterByName", Seq(classOf[Long], classOf[String]),"DELETE", """""", Routes.prefix + """parameter/deleteParameter/service/$id<[^/]+>/name/$name<[^/]+>"""))
        

// @LINE:49
private[this] lazy val controllers_UserController_getUser31_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_UserController_getUser31_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getUser(fakeValue[Long], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "getUser", Seq(classOf[Long], classOf[String]),"GET", """ Users""", Routes.prefix + """users/$id<[^/]+>"""))
        

// @LINE:50
private[this] lazy val controllers_UserController_addUser32_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/add"))))
private[this] lazy val controllers_UserController_addUser32_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).addUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "addUser", Nil,"POST", """""", Routes.prefix + """users/add"""))
        

// @LINE:51
private[this] lazy val controllers_UserController_updateUser33_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/update/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_UserController_updateUser33_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).updateUser(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "updateUser", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """users/update/$id<[^/]+>"""))
        

// @LINE:52
private[this] lazy val controllers_UserController_deleteUser34_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/delete/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_UserController_deleteUser34_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUser(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "deleteUser", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """users/delete/$id<[^/]+>"""))
        

// @LINE:53
private[this] lazy val controllers_UserController_getAllUsers35_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/getAllUsers/json"))))
private[this] lazy val controllers_UserController_getAllUsers35_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getAllUsers(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "getAllUsers", Seq(classOf[String]),"GET", """""", Routes.prefix + """users/getAllUsers/json"""))
        

// @LINE:54
private[this] lazy val controllers_UserController_isUserValid36_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/isUserValid"))))
private[this] lazy val controllers_UserController_isUserValid36_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isUserValid,
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "isUserValid", Nil,"POST", """""", Routes.prefix + """users/isUserValid"""))
        

// @LINE:55
private[this] lazy val controllers_UserController_isEmailExisted37_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/isEmailExisted"))))
private[this] lazy val controllers_UserController_isEmailExisted37_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isEmailExisted,
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "isEmailExisted", Nil,"POST", """""", Routes.prefix + """users/isEmailExisted"""))
        

// @LINE:56
private[this] lazy val controllers_UserController_deleteUserByUserNameandPassword38_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/delete/userName/"),DynamicPart("userName", """[^/]+""",true),StaticPart("/password/"),DynamicPart("password", """[^/]+""",true))))
private[this] lazy val controllers_UserController_deleteUserByUserNameandPassword38_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUserByUserNameandPassword(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.UserController", "deleteUserByUserNameandPassword", Seq(classOf[String], classOf[String]),"DELETE", """""", Routes.prefix + """users/delete/userName/$userName<[^/]+>/password/$password<[^/]+>"""))
        

// @LINE:59
private[this] lazy val controllers_Assets_at39_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at39_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:64
private[this] lazy val controllers_NewUserController_addUser40_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/addUser"))))
private[this] lazy val controllers_NewUserController_addUser40_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addUser", Nil,"POST", """ User""", Routes.prefix + """user/addUser"""))
        

// @LINE:65
private[this] lazy val controllers_NewUserController_login41_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/login"))))
private[this] lazy val controllers_NewUserController_login41_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).login,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "login", Nil,"POST", """""", Routes.prefix + """user/login"""))
        

// @LINE:66
private[this] lazy val controllers_NewUserController_addContributorToWorkflow42_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/addContributorToWorkflow"))))
private[this] lazy val controllers_NewUserController_addContributorToWorkflow42_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addContributorToWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addContributorToWorkflow", Nil,"POST", """""", Routes.prefix + """user/addContributorToWorkflow"""))
        

// @LINE:67
private[this] lazy val controllers_NewUserController_addUserToGroupAsAdmin43_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/addUserToGroupAsAdmin"))))
private[this] lazy val controllers_NewUserController_addUserToGroupAsAdmin43_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addUserToGroupAsAdmin,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addUserToGroupAsAdmin", Nil,"POST", """""", Routes.prefix + """user/addUserToGroupAsAdmin"""))
        

// @LINE:68
private[this] lazy val controllers_NewUserController_addUserToGroupAsMember44_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/addUserToGroupAsMember"))))
private[this] lazy val controllers_NewUserController_addUserToGroupAsMember44_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addUserToGroupAsMember,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addUserToGroupAsMember", Nil,"POST", """""", Routes.prefix + """user/addUserToGroupAsMember"""))
        

// @LINE:69
private[this] lazy val controllers_NewUserController_addFriendToUser45_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/addFriendToUser"))))
private[this] lazy val controllers_NewUserController_addFriendToUser45_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addFriendToUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addFriendToUser", Nil,"POST", """""", Routes.prefix + """user/addFriendToUser"""))
        

// @LINE:70
private[this] lazy val controllers_NewUserController_addSubscribeUserToUser46_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/addSubscribeUserToUser"))))
private[this] lazy val controllers_NewUserController_addSubscribeUserToUser46_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addSubscribeUserToUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addSubscribeUserToUser", Nil,"POST", """""", Routes.prefix + """user/addSubscribeUserToUser"""))
        

// @LINE:71
private[this] lazy val controllers_NewUserController_addSubscribeGroupToUser47_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/addSubscribeGroupToUser"))))
private[this] lazy val controllers_NewUserController_addSubscribeGroupToUser47_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addSubscribeGroupToUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addSubscribeGroupToUser", Nil,"POST", """""", Routes.prefix + """user/addSubscribeGroupToUser"""))
        

// @LINE:72
private[this] lazy val controllers_NewUserController_addSubscribeWorkflowToUser48_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/addSubscribeWorkflowToUser"))))
private[this] lazy val controllers_NewUserController_addSubscribeWorkflowToUser48_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addSubscribeWorkflowToUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "addSubscribeWorkflowToUser", Nil,"POST", """""", Routes.prefix + """user/addSubscribeWorkflowToUser"""))
        

// @LINE:73
private[this] lazy val controllers_NewUserController_deleteUser49_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteUser"))))
private[this] lazy val controllers_NewUserController_deleteUser49_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteUser", Nil,"POST", """""", Routes.prefix + """user/deleteUser"""))
        

// @LINE:74
private[this] lazy val controllers_NewUserController_deleteUserByUserNameAndPassword50_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteUserByUserNameAndPassword"))))
private[this] lazy val controllers_NewUserController_deleteUserByUserNameAndPassword50_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteUserByUserNameAndPassword,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteUserByUserNameAndPassword", Nil,"POST", """""", Routes.prefix + """user/deleteUserByUserNameAndPassword"""))
        

// @LINE:75
private[this] lazy val controllers_NewUserController_deleteContributorFromWorkflow51_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteContributorFromWorkflow"))))
private[this] lazy val controllers_NewUserController_deleteContributorFromWorkflow51_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteContributorFromWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteContributorFromWorkflow", Nil,"POST", """""", Routes.prefix + """user/deleteContributorFromWorkflow"""))
        

// @LINE:76
private[this] lazy val controllers_NewUserController_deleteUserFromGroup52_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteUserFromGroup"))))
private[this] lazy val controllers_NewUserController_deleteUserFromGroup52_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteUserFromGroup,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteUserFromGroup", Nil,"POST", """""", Routes.prefix + """user/deleteUserFromGroup"""))
        

// @LINE:77
private[this] lazy val controllers_NewUserController_deleteFriendFromUser53_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteFriendFromUser"))))
private[this] lazy val controllers_NewUserController_deleteFriendFromUser53_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteFriendFromUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteFriendFromUser", Nil,"POST", """""", Routes.prefix + """user/deleteFriendFromUser"""))
        

// @LINE:78
private[this] lazy val controllers_NewUserController_deleteSubscribeUserFromUser54_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteSubscribeUserFromUser"))))
private[this] lazy val controllers_NewUserController_deleteSubscribeUserFromUser54_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteSubscribeUserFromUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteSubscribeUserFromUser", Nil,"POST", """""", Routes.prefix + """user/deleteSubscribeUserFromUser"""))
        

// @LINE:79
private[this] lazy val controllers_NewUserController_deleteSubscribeGroupFromUser55_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteSubscribeGroupFromUser"))))
private[this] lazy val controllers_NewUserController_deleteSubscribeGroupFromUser55_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteSubscribeGroupFromUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteSubscribeGroupFromUser", Nil,"POST", """""", Routes.prefix + """user/deleteSubscribeGroupFromUser"""))
        

// @LINE:80
private[this] lazy val controllers_NewUserController_deleteSubscribeWorkflowFromUser56_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteSubscribeWorkflowFromUser"))))
private[this] lazy val controllers_NewUserController_deleteSubscribeWorkflowFromUser56_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteSubscribeWorkflowFromUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "deleteSubscribeWorkflowFromUser", Nil,"POST", """""", Routes.prefix + """user/deleteSubscribeWorkflowFromUser"""))
        

// @LINE:81
private[this] lazy val controllers_NewUserController_updateUser57_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/updateUser"))))
private[this] lazy val controllers_NewUserController_updateUser57_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).updateUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "updateUser", Nil,"POST", """""", Routes.prefix + """user/updateUser"""))
        

// @LINE:82
private[this] lazy val controllers_NewUserController_getUser58_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/getUser"))))
private[this] lazy val controllers_NewUserController_getUser58_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getUser", Nil,"POST", """""", Routes.prefix + """user/getUser"""))
        

// @LINE:83
private[this] lazy val controllers_NewUserController_getUserIdByUserName59_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/getUserIdByUserName"))))
private[this] lazy val controllers_NewUserController_getUserIdByUserName59_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getUserIdByUserName,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getUserIdByUserName", Nil,"POST", """""", Routes.prefix + """user/getUserIdByUserName"""))
        

// @LINE:84
private[this] lazy val controllers_NewUserController_getUserIdByEmail60_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/getUserIdByEmail"))))
private[this] lazy val controllers_NewUserController_getUserIdByEmail60_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getUserIdByEmail,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getUserIdByEmail", Nil,"POST", """""", Routes.prefix + """user/getUserIdByEmail"""))
        

// @LINE:85
private[this] lazy val controllers_NewUserController_getAllUsers61_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/getAllUsers"))))
private[this] lazy val controllers_NewUserController_getAllUsers61_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getAllUsers,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getAllUsers", Nil,"POST", """""", Routes.prefix + """user/getAllUsers"""))
        

// @LINE:86
private[this] lazy val controllers_NewUserController_getSubscribersNumber62_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/getSubscribersNumber"))))
private[this] lazy val controllers_NewUserController_getSubscribersNumber62_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getSubscribersNumber,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getSubscribersNumber", Nil,"POST", """""", Routes.prefix + """user/getSubscribersNumber"""))
        

// @LINE:87
private[this] lazy val controllers_NewUserController_getCollaboratorsNumber63_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/getCollaboratorsNumber"))))
private[this] lazy val controllers_NewUserController_getCollaboratorsNumber63_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getCollaboratorsNumber,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewUserController", "getCollaboratorsNumber", Nil,"POST", """""", Routes.prefix + """user/getCollaboratorsNumber"""))
        

// @LINE:90
private[this] lazy val controllers_NewWorkflowController_addWorkflow64_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/addWorkflow"))))
private[this] lazy val controllers_NewWorkflowController_addWorkflow64_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).addWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "addWorkflow", Nil,"POST", """Workflow""", Routes.prefix + """workflow/addWorkflow"""))
        

// @LINE:91
private[this] lazy val controllers_NewWorkflowController_addAttributeWorkflowToWorkflow65_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/addAttributeWorkflowToWorkflow"))))
private[this] lazy val controllers_NewWorkflowController_addAttributeWorkflowToWorkflow65_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).addAttributeWorkflowToWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "addAttributeWorkflowToWorkflow", Nil,"POST", """""", Routes.prefix + """workflow/addAttributeWorkflowToWorkflow"""))
        

// @LINE:92
private[this] lazy val controllers_NewWorkflowController_deleteWorkflow66_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/deleteWorkflow"))))
private[this] lazy val controllers_NewWorkflowController_deleteWorkflow66_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "deleteWorkflow", Nil,"POST", """""", Routes.prefix + """workflow/deleteWorkflow"""))
        

// @LINE:93
private[this] lazy val controllers_NewWorkflowController_deleteWorkflowByName67_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/deleteWorkflowByName"))))
private[this] lazy val controllers_NewWorkflowController_deleteWorkflowByName67_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteWorkflowByName,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "deleteWorkflowByName", Nil,"POST", """""", Routes.prefix + """workflow/deleteWorkflowByName"""))
        

// @LINE:94
private[this] lazy val controllers_NewWorkflowController_deleteAttributeWorkflowFromWorkflow68_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/deleteAttributeWorkflowFromWorkflow"))))
private[this] lazy val controllers_NewWorkflowController_deleteAttributeWorkflowFromWorkflow68_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteAttributeWorkflowFromWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "deleteAttributeWorkflowFromWorkflow", Nil,"POST", """""", Routes.prefix + """workflow/deleteAttributeWorkflowFromWorkflow"""))
        

// @LINE:95
private[this] lazy val controllers_NewWorkflowController_updateWorkflow69_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/updateWorkflow"))))
private[this] lazy val controllers_NewWorkflowController_updateWorkflow69_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).updateWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "updateWorkflow", Nil,"POST", """""", Routes.prefix + """workflow/updateWorkflow"""))
        

// @LINE:96
private[this] lazy val controllers_NewWorkflowController_getWorkflow70_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/getWorkflow"))))
private[this] lazy val controllers_NewWorkflowController_getWorkflow70_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "getWorkflow", Nil,"POST", """""", Routes.prefix + """workflow/getWorkflow"""))
        

// @LINE:97
private[this] lazy val controllers_NewWorkflowController_getWorkflowIdByName71_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/getWorkflowIdByName"))))
private[this] lazy val controllers_NewWorkflowController_getWorkflowIdByName71_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getWorkflowIdByName,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "getWorkflowIdByName", Nil,"POST", """""", Routes.prefix + """workflow/getWorkflowIdByName"""))
        

// @LINE:98
private[this] lazy val controllers_NewWorkflowController_getAllWorkflows72_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/getAllWorkflows"))))
private[this] lazy val controllers_NewWorkflowController_getAllWorkflows72_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getAllWorkflows,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "getAllWorkflows", Nil,"POST", """""", Routes.prefix + """workflow/getAllWorkflows"""))
        

// @LINE:99
private[this] lazy val controllers_NewWorkflowController_getWorkflowPopularity73_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/getWorkflowPopularity"))))
private[this] lazy val controllers_NewWorkflowController_getWorkflowPopularity73_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getWorkflowPopularity,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "getWorkflowPopularity", Nil,"POST", """""", Routes.prefix + """workflow/getWorkflowPopularity"""))
        

// @LINE:101
private[this] lazy val controllers_NewWorkflowController_addTagToWorkflow74_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/addTagToWorkflow"))))
private[this] lazy val controllers_NewWorkflowController_addTagToWorkflow74_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).addTagToWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "addTagToWorkflow", Nil,"POST", """""", Routes.prefix + """workflow/addTagToWorkflow"""))
        

// @LINE:102
private[this] lazy val controllers_NewWorkflowController_deleteTagFromWorkflow75_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("workflow/deleteTagFromWorkflow"))))
private[this] lazy val controllers_NewWorkflowController_deleteTagFromWorkflow75_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteTagFromWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewWorkflowController", "deleteTagFromWorkflow", Nil,"POST", """""", Routes.prefix + """workflow/deleteTagFromWorkflow"""))
        

// @LINE:105
private[this] lazy val controllers_NewTaskController_addTask76_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task/addTask"))))
private[this] lazy val controllers_NewTaskController_addTask76_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).addTask,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "addTask", Nil,"POST", """Task""", Routes.prefix + """task/addTask"""))
        

// @LINE:106
private[this] lazy val controllers_NewTaskController_addTaskToWorkflow77_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task/addTaskToWorkflow"))))
private[this] lazy val controllers_NewTaskController_addTaskToWorkflow77_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).addTaskToWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "addTaskToWorkflow", Nil,"POST", """""", Routes.prefix + """task/addTaskToWorkflow"""))
        

// @LINE:107
private[this] lazy val controllers_NewTaskController_deleteTask78_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task/deleteTask"))))
private[this] lazy val controllers_NewTaskController_deleteTask78_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).deleteTask,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "deleteTask", Nil,"POST", """""", Routes.prefix + """task/deleteTask"""))
        

// @LINE:108
private[this] lazy val controllers_NewTaskController_updateTask79_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task/updateTask"))))
private[this] lazy val controllers_NewTaskController_updateTask79_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).updateTask,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "updateTask", Nil,"POST", """""", Routes.prefix + """task/updateTask"""))
        

// @LINE:109
private[this] lazy val controllers_NewTaskController_getTask80_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("task/getTask"))))
private[this] lazy val controllers_NewTaskController_getTask80_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).getTask,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTaskController", "getTask", Nil,"POST", """""", Routes.prefix + """task/getTask"""))
        

// @LINE:112
private[this] lazy val controllers_NewInputController_addInput81_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("input/addInput"))))
private[this] lazy val controllers_NewInputController_addInput81_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).addInput,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "addInput", Nil,"POST", """Input""", Routes.prefix + """input/addInput"""))
        

// @LINE:113
private[this] lazy val controllers_NewInputController_addInputToWorkflow82_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("input/addInputToWorkflow"))))
private[this] lazy val controllers_NewInputController_addInputToWorkflow82_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).addInputToWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "addInputToWorkflow", Nil,"POST", """""", Routes.prefix + """input/addInputToWorkflow"""))
        

// @LINE:114
private[this] lazy val controllers_NewInputController_deleteInput83_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("input/deleteInput"))))
private[this] lazy val controllers_NewInputController_deleteInput83_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).deleteInput,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "deleteInput", Nil,"POST", """""", Routes.prefix + """input/deleteInput"""))
        

// @LINE:115
private[this] lazy val controllers_NewInputController_updateInput84_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("input/updateInput"))))
private[this] lazy val controllers_NewInputController_updateInput84_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).updateInput,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "updateInput", Nil,"POST", """""", Routes.prefix + """input/updateInput"""))
        

// @LINE:116
private[this] lazy val controllers_NewInputController_getInput85_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("input/getInput"))))
private[this] lazy val controllers_NewInputController_getInput85_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).getInput,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInputController", "getInput", Nil,"POST", """""", Routes.prefix + """input/getInput"""))
        

// @LINE:119
private[this] lazy val controllers_NewOutputController_addOutput86_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("output/addOutput"))))
private[this] lazy val controllers_NewOutputController_addOutput86_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).addOutput,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "addOutput", Nil,"POST", """Output""", Routes.prefix + """output/addOutput"""))
        

// @LINE:120
private[this] lazy val controllers_NewOutputController_addOutputToWorkflow87_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("output/addOutputToWorkflow"))))
private[this] lazy val controllers_NewOutputController_addOutputToWorkflow87_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).addOutputToWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "addOutputToWorkflow", Nil,"POST", """""", Routes.prefix + """output/addOutputToWorkflow"""))
        

// @LINE:121
private[this] lazy val controllers_NewOutputController_deleteOutput88_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("output/deleteOutput"))))
private[this] lazy val controllers_NewOutputController_deleteOutput88_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).deleteOutput,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "deleteOutput", Nil,"POST", """""", Routes.prefix + """output/deleteOutput"""))
        

// @LINE:122
private[this] lazy val controllers_NewOutputController_updateOutput89_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("output/updateOutput"))))
private[this] lazy val controllers_NewOutputController_updateOutput89_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).updateOutput,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "updateOutput", Nil,"POST", """""", Routes.prefix + """output/updateOutput"""))
        

// @LINE:123
private[this] lazy val controllers_NewOutputController_getOutput90_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("output/getOutput"))))
private[this] lazy val controllers_NewOutputController_getOutput90_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).getOutput,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewOutputController", "getOutput", Nil,"POST", """""", Routes.prefix + """output/getOutput"""))
        

// @LINE:126
private[this] lazy val controllers_NewInstructionController_addInstruction91_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instruction/addInstruction"))))
private[this] lazy val controllers_NewInstructionController_addInstruction91_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).addInstruction,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "addInstruction", Nil,"POST", """Instruction""", Routes.prefix + """instruction/addInstruction"""))
        

// @LINE:127
private[this] lazy val controllers_NewInstructionController_addInstructionToWorkflow92_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instruction/addInstructionToWorkflow"))))
private[this] lazy val controllers_NewInstructionController_addInstructionToWorkflow92_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).addInstructionToWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "addInstructionToWorkflow", Nil,"POST", """""", Routes.prefix + """instruction/addInstructionToWorkflow"""))
        

// @LINE:128
private[this] lazy val controllers_NewInstructionController_deleteInstruction93_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instruction/deleteInstruction"))))
private[this] lazy val controllers_NewInstructionController_deleteInstruction93_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).deleteInstruction,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "deleteInstruction", Nil,"POST", """""", Routes.prefix + """instruction/deleteInstruction"""))
        

// @LINE:129
private[this] lazy val controllers_NewInstructionController_updateInstruction94_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instruction/updateInstruction"))))
private[this] lazy val controllers_NewInstructionController_updateInstruction94_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).updateInstruction,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "updateInstruction", Nil,"POST", """""", Routes.prefix + """instruction/updateInstruction"""))
        

// @LINE:130
private[this] lazy val controllers_NewInstructionController_getInstruction95_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("instruction/getInstruction"))))
private[this] lazy val controllers_NewInstructionController_getInstruction95_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).getInstruction,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewInstructionController", "getInstruction", Nil,"POST", """""", Routes.prefix + """instruction/getInstruction"""))
        

// @LINE:133
private[this] lazy val controllers_NewDatasetController_addDataset96_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("datasetV2/addDataset"))))
private[this] lazy val controllers_NewDatasetController_addDataset96_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).addDataset,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "addDataset", Nil,"POST", """Dataset""", Routes.prefix + """datasetV2/addDataset"""))
        

// @LINE:134
private[this] lazy val controllers_NewDatasetController_addDatasetToWorkflow97_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("datasetV2/addDatasetToWorkflow"))))
private[this] lazy val controllers_NewDatasetController_addDatasetToWorkflow97_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).addDatasetToWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "addDatasetToWorkflow", Nil,"POST", """""", Routes.prefix + """datasetV2/addDatasetToWorkflow"""))
        

// @LINE:135
private[this] lazy val controllers_NewDatasetController_deleteDataset98_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("datasetV2/deleteDataset"))))
private[this] lazy val controllers_NewDatasetController_deleteDataset98_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).deleteDataset,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "deleteDataset", Nil,"POST", """""", Routes.prefix + """datasetV2/deleteDataset"""))
        

// @LINE:136
private[this] lazy val controllers_NewDatasetController_updateDataset99_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("datasetV2/updateDataset"))))
private[this] lazy val controllers_NewDatasetController_updateDataset99_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).updateDataset,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "updateDataset", Nil,"POST", """""", Routes.prefix + """datasetV2/updateDataset"""))
        

// @LINE:137
private[this] lazy val controllers_NewDatasetController_getDataset100_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("datasetV2/getDataset"))))
private[this] lazy val controllers_NewDatasetController_getDataset100_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).getDataset,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewDatasetController", "getDataset", Nil,"POST", """""", Routes.prefix + """datasetV2/getDataset"""))
        

// @LINE:140
private[this] lazy val controllers_NewLinkController_addLink101_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("link/addLink"))))
private[this] lazy val controllers_NewLinkController_addLink101_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).addLink,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "addLink", Nil,"POST", """Link""", Routes.prefix + """link/addLink"""))
        

// @LINE:141
private[this] lazy val controllers_NewLinkController_addLinkToWorkflow102_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("link/addLinkToWorkflow"))))
private[this] lazy val controllers_NewLinkController_addLinkToWorkflow102_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).addLinkToWorkflow,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "addLinkToWorkflow", Nil,"POST", """""", Routes.prefix + """link/addLinkToWorkflow"""))
        

// @LINE:142
private[this] lazy val controllers_NewLinkController_deleteLink103_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("link/deleteLink"))))
private[this] lazy val controllers_NewLinkController_deleteLink103_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).deleteLink,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "deleteLink", Nil,"POST", """""", Routes.prefix + """link/deleteLink"""))
        

// @LINE:143
private[this] lazy val controllers_NewLinkController_updateLink104_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("link/updateLink"))))
private[this] lazy val controllers_NewLinkController_updateLink104_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).updateLink,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "updateLink", Nil,"POST", """""", Routes.prefix + """link/updateLink"""))
        

// @LINE:144
private[this] lazy val controllers_NewLinkController_getLink105_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("link/getLink"))))
private[this] lazy val controllers_NewLinkController_getLink105_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).getLink,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewLinkController", "getLink", Nil,"POST", """""", Routes.prefix + """link/getLink"""))
        

// @LINE:147
private[this] lazy val controllers_NewGroupController_addGroup106_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("group/addGroup"))))
private[this] lazy val controllers_NewGroupController_addGroup106_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).addGroup,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "addGroup", Nil,"POST", """Group""", Routes.prefix + """group/addGroup"""))
        

// @LINE:148
private[this] lazy val controllers_NewGroupController_deleteGroup107_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("group/deleteGroup"))))
private[this] lazy val controllers_NewGroupController_deleteGroup107_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).deleteGroup,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "deleteGroup", Nil,"POST", """""", Routes.prefix + """group/deleteGroup"""))
        

// @LINE:149
private[this] lazy val controllers_NewGroupController_updateGroup108_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("group/updateGroup"))))
private[this] lazy val controllers_NewGroupController_updateGroup108_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).updateGroup,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "updateGroup", Nil,"POST", """""", Routes.prefix + """group/updateGroup"""))
        

// @LINE:150
private[this] lazy val controllers_NewGroupController_getGroup109_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("group/getGroup"))))
private[this] lazy val controllers_NewGroupController_getGroup109_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).getGroup,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "getGroup", Nil,"POST", """""", Routes.prefix + """group/getGroup"""))
        

// @LINE:151
private[this] lazy val controllers_NewGroupController_getGroupIdByName110_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("group/getGroupIdByName"))))
private[this] lazy val controllers_NewGroupController_getGroupIdByName110_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).getGroupIdByName,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "getGroupIdByName", Nil,"POST", """""", Routes.prefix + """group/getGroupIdByName"""))
        

// @LINE:152
private[this] lazy val controllers_NewGroupController_getAllGroups111_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("group/getAllGroups"))))
private[this] lazy val controllers_NewGroupController_getAllGroups111_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).getAllGroups,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewGroupController", "getAllGroups", Nil,"POST", """""", Routes.prefix + """group/getAllGroups"""))
        

// @LINE:155
private[this] lazy val controllers_NewTagController_addTag112_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tag/addTag"))))
private[this] lazy val controllers_NewTagController_addTag112_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).addTag,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "addTag", Nil,"POST", """Tag""", Routes.prefix + """tag/addTag"""))
        

// @LINE:156
private[this] lazy val controllers_NewTagController_deleteTag113_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tag/deleteTag"))))
private[this] lazy val controllers_NewTagController_deleteTag113_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).deleteTag,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "deleteTag", Nil,"POST", """""", Routes.prefix + """tag/deleteTag"""))
        

// @LINE:157
private[this] lazy val controllers_NewTagController_updateTag114_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tag/updateTag"))))
private[this] lazy val controllers_NewTagController_updateTag114_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).updateTag,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "updateTag", Nil,"POST", """""", Routes.prefix + """tag/updateTag"""))
        

// @LINE:158
private[this] lazy val controllers_NewTagController_getTag115_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tag/getTag"))))
private[this] lazy val controllers_NewTagController_getTag115_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).getTag,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "getTag", Nil,"POST", """""", Routes.prefix + """tag/getTag"""))
        

// @LINE:159
private[this] lazy val controllers_NewTagController_getTagIdByName116_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tag/getTagIdByName"))))
private[this] lazy val controllers_NewTagController_getTagIdByName116_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).getTagIdByName,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "getTagIdByName", Nil,"POST", """""", Routes.prefix + """tag/getTagIdByName"""))
        

// @LINE:160
private[this] lazy val controllers_NewTagController_getAllTags117_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tag/getAllTags"))))
private[this] lazy val controllers_NewTagController_getAllTags117_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).getAllTags,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewTagController", "getAllTags", Nil,"POST", """""", Routes.prefix + """tag/getAllTags"""))
        

// @LINE:163
private[this] lazy val controllers_NewPostController_addPost118_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/addPost"))))
private[this] lazy val controllers_NewPostController_addPost118_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).addPost,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "addPost", Nil,"POST", """Post""", Routes.prefix + """post/addPost"""))
        

// @LINE:164
private[this] lazy val controllers_NewPostController_addPostToUser119_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/addPostToUser"))))
private[this] lazy val controllers_NewPostController_addPostToUser119_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).addPostToUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "addPostToUser", Nil,"POST", """""", Routes.prefix + """post/addPostToUser"""))
        

// @LINE:165
private[this] lazy val controllers_NewPostController_addTagToPost120_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/addTagToPost"))))
private[this] lazy val controllers_NewPostController_addTagToPost120_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).addTagToPost,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "addTagToPost", Nil,"POST", """""", Routes.prefix + """post/addTagToPost"""))
        

// @LINE:166
private[this] lazy val controllers_NewPostController_deletePost121_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/deletePost"))))
private[this] lazy val controllers_NewPostController_deletePost121_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).deletePost,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "deletePost", Nil,"POST", """""", Routes.prefix + """post/deletePost"""))
        

// @LINE:167
private[this] lazy val controllers_NewPostController_deleteTagFromPost122_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/deleteTagFromPost"))))
private[this] lazy val controllers_NewPostController_deleteTagFromPost122_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).deleteTagFromPost,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "deleteTagFromPost", Nil,"POST", """""", Routes.prefix + """post/deleteTagFromPost"""))
        

// @LINE:168
private[this] lazy val controllers_NewPostController_updatePost123_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/updatePost"))))
private[this] lazy val controllers_NewPostController_updatePost123_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).updatePost,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "updatePost", Nil,"POST", """""", Routes.prefix + """post/updatePost"""))
        

// @LINE:169
private[this] lazy val controllers_NewPostController_getPost124_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/getPost"))))
private[this] lazy val controllers_NewPostController_getPost124_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).getPost,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "getPost", Nil,"POST", """""", Routes.prefix + """post/getPost"""))
        

// @LINE:170
private[this] lazy val controllers_NewPostController_getPostsUnderDomainAndDomainName125_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/getPostsUnderDomainAndDomainName"))))
private[this] lazy val controllers_NewPostController_getPostsUnderDomainAndDomainName125_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).getPostsUnderDomainAndDomainName,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewPostController", "getPostsUnderDomainAndDomainName", Nil,"POST", """""", Routes.prefix + """post/getPostsUnderDomainAndDomainName"""))
        

// @LINE:173
private[this] lazy val controllers_NewReplyController_addReply126_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reply/addReply"))))
private[this] lazy val controllers_NewReplyController_addReply126_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).addReply,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "addReply", Nil,"POST", """Reply""", Routes.prefix + """reply/addReply"""))
        

// @LINE:174
private[this] lazy val controllers_NewReplyController_addReplyToPost127_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reply/addReplyToPost"))))
private[this] lazy val controllers_NewReplyController_addReplyToPost127_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).addReplyToPost,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "addReplyToPost", Nil,"POST", """""", Routes.prefix + """reply/addReplyToPost"""))
        

// @LINE:175
private[this] lazy val controllers_NewReplyController_deleteReply128_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reply/deleteReply"))))
private[this] lazy val controllers_NewReplyController_deleteReply128_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).deleteReply,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "deleteReply", Nil,"POST", """""", Routes.prefix + """reply/deleteReply"""))
        

// @LINE:176
private[this] lazy val controllers_NewReplyController_updateReply129_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reply/updateReply"))))
private[this] lazy val controllers_NewReplyController_updateReply129_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).updateReply,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "updateReply", Nil,"POST", """""", Routes.prefix + """reply/updateReply"""))
        

// @LINE:177
private[this] lazy val controllers_NewReplyController_getReply130_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reply/getReply"))))
private[this] lazy val controllers_NewReplyController_getReply130_invoker = createInvoker(
play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).getReply,
HandlerDef(this.getClass.getClassLoader, "", "controllers.NewReplyController", "getReply", Nil,"POST", """""", Routes.prefix + """reply/getReply"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getClimateService/$name<[^/]+>/json""","""@controllers.ClimateServiceController@.getClimateService(name:String, format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getClimateService/id/$id<[^/]+>""","""@controllers.ClimateServiceController@.getClimateServiceById(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllClimateServices/json""","""@controllers.ClimateServiceController@.getAllClimateServices(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllMostRecentClimateServicesByCreateTime/json""","""@controllers.ClimateServiceController@.getAllClimateServicesOrderByCreateTime(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllMostRecentClimateServicesByLatestAccessTime/json""","""@controllers.ClimateServiceController@.getAllClimateServicesOrderByLatestAccessTime(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllMostUsedClimateServices/json""","""@controllers.ClimateServiceController@.getAllClimateServicesOrderByCount(format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/addClimateService""","""@controllers.ClimateServiceController@.addClimateService"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/getAllServiceEntries/json""","""@controllers.ClimateServiceController@.getAllServiceEntries(format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/addServiceEntry""","""@controllers.ClimateServiceController@.addServiceEntry"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/updateClimateService/id/$id<[^/]+>""","""@controllers.ClimateServiceController@.updateClimateServiceById(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/updateClimateService/name/$oldName<[^/]+>""","""@controllers.ClimateServiceController@.updateClimateServiceByName(oldName:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/deleteClimateService/id/$id<[^/]+>""","""@controllers.ClimateServiceController@.deleteClimateServiceById(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """climateService/deleteClimateService/name/$name<[^/]+>""","""@controllers.ClimateServiceController@.deleteClimateServiceByName(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/getAllInstruments/json""","""@controllers.InstrumentController@.getAllInstruments(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/getInstrument/id/$id<[^/]+>/json""","""@controllers.InstrumentController@.getInstrument(id:Long, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/addInstrument""","""@controllers.InstrumentController@.addInstrument"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/updateInstrument/id/$id<[^/]+>""","""@controllers.InstrumentController@.updateInstrumentById(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instrument/deleteInstrument/id/$id<[^/]+>""","""@controllers.InstrumentController@.deleteInstrument(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/getAllDatasets/json""","""@controllers.DatasetController@.getAllDatasets(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/getDataset/id/$id<[^/]+>/json""","""@controllers.DatasetController@.getDataset(id:Long, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/addDataset""","""@controllers.DatasetController@.addDataset"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/updateDataset/id/$id<[^/]+>""","""@controllers.DatasetController@.updateDatasetById(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/deleteDataset/id/$id<[^/]+>""","""@controllers.DatasetController@.deleteDataset(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dataset/queryDataset""","""@controllers.DatasetController@.queryDatasets"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/getAllParameters/json""","""@controllers.ParameterController@.getAllParameters(format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/getParameter/service/$id<[^/]+>/name/$name<[^/]+>/json""","""@controllers.ParameterController@.getParameterByName(id:Long, name:String, format:String = "json")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/getParameter/id/$id<[^/]+>/json""","""@controllers.ParameterController@.getParameterById(id:Long, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/addParameter""","""@controllers.ParameterController@.addParameter"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/updateParameter/id/$id<[^/]+>""","""@controllers.ParameterController@.updateParameterById(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/updateParameter/name/$oldName<[^/]+>""","""@controllers.ParameterController@.updateParameterByName(oldName:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """parameter/deleteParameter/service/$id<[^/]+>/name/$name<[^/]+>""","""@controllers.ParameterController@.deleteParameterByName(id:Long, name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/$id<[^/]+>""","""@controllers.UserController@.getUser(id:Long, format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/add""","""@controllers.UserController@.addUser"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/update/$id<[^/]+>""","""@controllers.UserController@.updateUser(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/delete/$id<[^/]+>""","""@controllers.UserController@.deleteUser(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/getAllUsers/json""","""@controllers.UserController@.getAllUsers(format:String = "json")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/isUserValid""","""@controllers.UserController@.isUserValid"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/isEmailExisted""","""@controllers.UserController@.isEmailExisted"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/delete/userName/$userName<[^/]+>/password/$password<[^/]+>""","""@controllers.UserController@.deleteUserByUserNameandPassword(userName:String, password:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/addUser""","""@controllers.NewUserController@.addUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/login""","""@controllers.NewUserController@.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/addContributorToWorkflow""","""@controllers.NewUserController@.addContributorToWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/addUserToGroupAsAdmin""","""@controllers.NewUserController@.addUserToGroupAsAdmin"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/addUserToGroupAsMember""","""@controllers.NewUserController@.addUserToGroupAsMember"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/addFriendToUser""","""@controllers.NewUserController@.addFriendToUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/addSubscribeUserToUser""","""@controllers.NewUserController@.addSubscribeUserToUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/addSubscribeGroupToUser""","""@controllers.NewUserController@.addSubscribeGroupToUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/addSubscribeWorkflowToUser""","""@controllers.NewUserController@.addSubscribeWorkflowToUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteUser""","""@controllers.NewUserController@.deleteUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteUserByUserNameAndPassword""","""@controllers.NewUserController@.deleteUserByUserNameAndPassword"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteContributorFromWorkflow""","""@controllers.NewUserController@.deleteContributorFromWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteUserFromGroup""","""@controllers.NewUserController@.deleteUserFromGroup"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteFriendFromUser""","""@controllers.NewUserController@.deleteFriendFromUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteSubscribeUserFromUser""","""@controllers.NewUserController@.deleteSubscribeUserFromUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteSubscribeGroupFromUser""","""@controllers.NewUserController@.deleteSubscribeGroupFromUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteSubscribeWorkflowFromUser""","""@controllers.NewUserController@.deleteSubscribeWorkflowFromUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/updateUser""","""@controllers.NewUserController@.updateUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/getUser""","""@controllers.NewUserController@.getUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/getUserIdByUserName""","""@controllers.NewUserController@.getUserIdByUserName"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/getUserIdByEmail""","""@controllers.NewUserController@.getUserIdByEmail"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/getAllUsers""","""@controllers.NewUserController@.getAllUsers"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/getSubscribersNumber""","""@controllers.NewUserController@.getSubscribersNumber"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/getCollaboratorsNumber""","""@controllers.NewUserController@.getCollaboratorsNumber"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/addWorkflow""","""@controllers.NewWorkflowController@.addWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/addAttributeWorkflowToWorkflow""","""@controllers.NewWorkflowController@.addAttributeWorkflowToWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/deleteWorkflow""","""@controllers.NewWorkflowController@.deleteWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/deleteWorkflowByName""","""@controllers.NewWorkflowController@.deleteWorkflowByName"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/deleteAttributeWorkflowFromWorkflow""","""@controllers.NewWorkflowController@.deleteAttributeWorkflowFromWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/updateWorkflow""","""@controllers.NewWorkflowController@.updateWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/getWorkflow""","""@controllers.NewWorkflowController@.getWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/getWorkflowIdByName""","""@controllers.NewWorkflowController@.getWorkflowIdByName"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/getAllWorkflows""","""@controllers.NewWorkflowController@.getAllWorkflows"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/getWorkflowPopularity""","""@controllers.NewWorkflowController@.getWorkflowPopularity"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/addTagToWorkflow""","""@controllers.NewWorkflowController@.addTagToWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """workflow/deleteTagFromWorkflow""","""@controllers.NewWorkflowController@.deleteTagFromWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task/addTask""","""@controllers.NewTaskController@.addTask"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task/addTaskToWorkflow""","""@controllers.NewTaskController@.addTaskToWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task/deleteTask""","""@controllers.NewTaskController@.deleteTask"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task/updateTask""","""@controllers.NewTaskController@.updateTask"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """task/getTask""","""@controllers.NewTaskController@.getTask"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """input/addInput""","""@controllers.NewInputController@.addInput"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """input/addInputToWorkflow""","""@controllers.NewInputController@.addInputToWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """input/deleteInput""","""@controllers.NewInputController@.deleteInput"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """input/updateInput""","""@controllers.NewInputController@.updateInput"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """input/getInput""","""@controllers.NewInputController@.getInput"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """output/addOutput""","""@controllers.NewOutputController@.addOutput"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """output/addOutputToWorkflow""","""@controllers.NewOutputController@.addOutputToWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """output/deleteOutput""","""@controllers.NewOutputController@.deleteOutput"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """output/updateOutput""","""@controllers.NewOutputController@.updateOutput"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """output/getOutput""","""@controllers.NewOutputController@.getOutput"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instruction/addInstruction""","""@controllers.NewInstructionController@.addInstruction"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instruction/addInstructionToWorkflow""","""@controllers.NewInstructionController@.addInstructionToWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instruction/deleteInstruction""","""@controllers.NewInstructionController@.deleteInstruction"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instruction/updateInstruction""","""@controllers.NewInstructionController@.updateInstruction"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """instruction/getInstruction""","""@controllers.NewInstructionController@.getInstruction"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """datasetV2/addDataset""","""@controllers.NewDatasetController@.addDataset"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """datasetV2/addDatasetToWorkflow""","""@controllers.NewDatasetController@.addDatasetToWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """datasetV2/deleteDataset""","""@controllers.NewDatasetController@.deleteDataset"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """datasetV2/updateDataset""","""@controllers.NewDatasetController@.updateDataset"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """datasetV2/getDataset""","""@controllers.NewDatasetController@.getDataset"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """link/addLink""","""@controllers.NewLinkController@.addLink"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """link/addLinkToWorkflow""","""@controllers.NewLinkController@.addLinkToWorkflow"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """link/deleteLink""","""@controllers.NewLinkController@.deleteLink"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """link/updateLink""","""@controllers.NewLinkController@.updateLink"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """link/getLink""","""@controllers.NewLinkController@.getLink"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """group/addGroup""","""@controllers.NewGroupController@.addGroup"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """group/deleteGroup""","""@controllers.NewGroupController@.deleteGroup"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """group/updateGroup""","""@controllers.NewGroupController@.updateGroup"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """group/getGroup""","""@controllers.NewGroupController@.getGroup"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """group/getGroupIdByName""","""@controllers.NewGroupController@.getGroupIdByName"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """group/getAllGroups""","""@controllers.NewGroupController@.getAllGroups"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tag/addTag""","""@controllers.NewTagController@.addTag"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tag/deleteTag""","""@controllers.NewTagController@.deleteTag"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tag/updateTag""","""@controllers.NewTagController@.updateTag"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tag/getTag""","""@controllers.NewTagController@.getTag"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tag/getTagIdByName""","""@controllers.NewTagController@.getTagIdByName"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tag/getAllTags""","""@controllers.NewTagController@.getAllTags"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/addPost""","""@controllers.NewPostController@.addPost"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/addPostToUser""","""@controllers.NewPostController@.addPostToUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/addTagToPost""","""@controllers.NewPostController@.addTagToPost"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/deletePost""","""@controllers.NewPostController@.deletePost"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/deleteTagFromPost""","""@controllers.NewPostController@.deleteTagFromPost"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/updatePost""","""@controllers.NewPostController@.updatePost"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/getPost""","""@controllers.NewPostController@.getPost"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/getPostsUnderDomainAndDomainName""","""@controllers.NewPostController@.getPostsUnderDomainAndDomainName"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reply/addReply""","""@controllers.NewReplyController@.addReply"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reply/addReplyToPost""","""@controllers.NewReplyController@.addReplyToPost"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reply/deleteReply""","""@controllers.NewReplyController@.deleteReply"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reply/updateReply""","""@controllers.NewReplyController@.updateReply"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reply/getReply""","""@controllers.NewReplyController@.getReply""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:10
case controllers_ClimateServiceController_getClimateService0_route(params) => {
   call(params.fromPath[String]("name", None), Param[String]("format", Right("json"))) { (name, format) =>
        controllers_ClimateServiceController_getClimateService0_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateService(name, format))
   }
}
        

// @LINE:11
case controllers_ClimateServiceController_getClimateServiceById1_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ClimateServiceController_getClimateServiceById1_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getClimateServiceById(id))
   }
}
        

// @LINE:12
case controllers_ClimateServiceController_getAllClimateServices2_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllClimateServices2_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServices(format))
   }
}
        

// @LINE:13
case controllers_ClimateServiceController_getAllClimateServicesOrderByCreateTime3_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllClimateServicesOrderByCreateTime3_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCreateTime(format))
   }
}
        

// @LINE:14
case controllers_ClimateServiceController_getAllClimateServicesOrderByLatestAccessTime4_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllClimateServicesOrderByLatestAccessTime4_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByLatestAccessTime(format))
   }
}
        

// @LINE:15
case controllers_ClimateServiceController_getAllClimateServicesOrderByCount5_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllClimateServicesOrderByCount5_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllClimateServicesOrderByCount(format))
   }
}
        

// @LINE:16
case controllers_ClimateServiceController_addClimateService6_route(params) => {
   call { 
        controllers_ClimateServiceController_addClimateService6_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addClimateService)
   }
}
        

// @LINE:17
case controllers_ClimateServiceController_getAllServiceEntries7_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ClimateServiceController_getAllServiceEntries7_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).getAllServiceEntries(format))
   }
}
        

// @LINE:18
case controllers_ClimateServiceController_addServiceEntry8_route(params) => {
   call { 
        controllers_ClimateServiceController_addServiceEntry8_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).addServiceEntry)
   }
}
        

// @LINE:19
case controllers_ClimateServiceController_updateClimateServiceById9_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ClimateServiceController_updateClimateServiceById9_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceById(id))
   }
}
        

// @LINE:20
case controllers_ClimateServiceController_updateClimateServiceByName10_route(params) => {
   call(params.fromPath[String]("oldName", None)) { (oldName) =>
        controllers_ClimateServiceController_updateClimateServiceByName10_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).updateClimateServiceByName(oldName))
   }
}
        

// @LINE:21
case controllers_ClimateServiceController_deleteClimateServiceById11_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ClimateServiceController_deleteClimateServiceById11_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceById(id))
   }
}
        

// @LINE:22
case controllers_ClimateServiceController_deleteClimateServiceByName12_route(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        controllers_ClimateServiceController_deleteClimateServiceByName12_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ClimateServiceController]).deleteClimateServiceByName(name))
   }
}
        

// @LINE:25
case controllers_InstrumentController_getAllInstruments13_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_InstrumentController_getAllInstruments13_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getAllInstruments(format))
   }
}
        

// @LINE:26
case controllers_InstrumentController_getInstrument14_route(params) => {
   call(params.fromPath[Long]("id", None), Param[String]("format", Right("json"))) { (id, format) =>
        controllers_InstrumentController_getInstrument14_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).getInstrument(id, format))
   }
}
        

// @LINE:27
case controllers_InstrumentController_addInstrument15_route(params) => {
   call { 
        controllers_InstrumentController_addInstrument15_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).addInstrument)
   }
}
        

// @LINE:28
case controllers_InstrumentController_updateInstrumentById16_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_InstrumentController_updateInstrumentById16_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).updateInstrumentById(id))
   }
}
        

// @LINE:29
case controllers_InstrumentController_deleteInstrument17_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_InstrumentController_deleteInstrument17_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.InstrumentController]).deleteInstrument(id))
   }
}
        

// @LINE:32
case controllers_DatasetController_getAllDatasets18_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_DatasetController_getAllDatasets18_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getAllDatasets(format))
   }
}
        

// @LINE:33
case controllers_DatasetController_getDataset19_route(params) => {
   call(params.fromPath[Long]("id", None), Param[String]("format", Right("json"))) { (id, format) =>
        controllers_DatasetController_getDataset19_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).getDataset(id, format))
   }
}
        

// @LINE:34
case controllers_DatasetController_addDataset20_route(params) => {
   call { 
        controllers_DatasetController_addDataset20_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).addDataset)
   }
}
        

// @LINE:35
case controllers_DatasetController_updateDatasetById21_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DatasetController_updateDatasetById21_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).updateDatasetById(id))
   }
}
        

// @LINE:36
case controllers_DatasetController_deleteDataset22_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_DatasetController_deleteDataset22_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).deleteDataset(id))
   }
}
        

// @LINE:37
case controllers_DatasetController_queryDatasets23_route(params) => {
   call { 
        controllers_DatasetController_queryDatasets23_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DatasetController]).queryDatasets)
   }
}
        

// @LINE:40
case controllers_ParameterController_getAllParameters24_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_ParameterController_getAllParameters24_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getAllParameters(format))
   }
}
        

// @LINE:41
case controllers_ParameterController_getParameterByName25_route(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[String]("name", None), Param[String]("format", Right("json"))) { (id, name, format) =>
        controllers_ParameterController_getParameterByName25_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterByName(id, name, format))
   }
}
        

// @LINE:42
case controllers_ParameterController_getParameterById26_route(params) => {
   call(params.fromPath[Long]("id", None), Param[String]("format", Right("json"))) { (id, format) =>
        controllers_ParameterController_getParameterById26_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).getParameterById(id, format))
   }
}
        

// @LINE:43
case controllers_ParameterController_addParameter27_route(params) => {
   call { 
        controllers_ParameterController_addParameter27_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).addParameter)
   }
}
        

// @LINE:44
case controllers_ParameterController_updateParameterById28_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ParameterController_updateParameterById28_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterById(id))
   }
}
        

// @LINE:45
case controllers_ParameterController_updateParameterByName29_route(params) => {
   call(params.fromPath[String]("oldName", None)) { (oldName) =>
        controllers_ParameterController_updateParameterByName29_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).updateParameterByName(oldName))
   }
}
        

// @LINE:46
case controllers_ParameterController_deleteParameterByName30_route(params) => {
   call(params.fromPath[Long]("id", None), params.fromPath[String]("name", None)) { (id, name) =>
        controllers_ParameterController_deleteParameterByName30_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.ParameterController]).deleteParameterByName(id, name))
   }
}
        

// @LINE:49
case controllers_UserController_getUser31_route(params) => {
   call(params.fromPath[Long]("id", None), Param[String]("format", Right("json"))) { (id, format) =>
        controllers_UserController_getUser31_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getUser(id, format))
   }
}
        

// @LINE:50
case controllers_UserController_addUser32_route(params) => {
   call { 
        controllers_UserController_addUser32_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).addUser)
   }
}
        

// @LINE:51
case controllers_UserController_updateUser33_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_updateUser33_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).updateUser(id))
   }
}
        

// @LINE:52
case controllers_UserController_deleteUser34_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UserController_deleteUser34_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUser(id))
   }
}
        

// @LINE:53
case controllers_UserController_getAllUsers35_route(params) => {
   call(Param[String]("format", Right("json"))) { (format) =>
        controllers_UserController_getAllUsers35_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).getAllUsers(format))
   }
}
        

// @LINE:54
case controllers_UserController_isUserValid36_route(params) => {
   call { 
        controllers_UserController_isUserValid36_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isUserValid)
   }
}
        

// @LINE:55
case controllers_UserController_isEmailExisted37_route(params) => {
   call { 
        controllers_UserController_isEmailExisted37_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).isEmailExisted)
   }
}
        

// @LINE:56
case controllers_UserController_deleteUserByUserNameandPassword38_route(params) => {
   call(params.fromPath[String]("userName", None), params.fromPath[String]("password", None)) { (userName, password) =>
        controllers_UserController_deleteUserByUserNameandPassword38_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.UserController]).deleteUserByUserNameandPassword(userName, password))
   }
}
        

// @LINE:59
case controllers_Assets_at39_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at39_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:64
case controllers_NewUserController_addUser40_route(params) => {
   call { 
        controllers_NewUserController_addUser40_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addUser)
   }
}
        

// @LINE:65
case controllers_NewUserController_login41_route(params) => {
   call { 
        controllers_NewUserController_login41_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).login)
   }
}
        

// @LINE:66
case controllers_NewUserController_addContributorToWorkflow42_route(params) => {
   call { 
        controllers_NewUserController_addContributorToWorkflow42_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addContributorToWorkflow)
   }
}
        

// @LINE:67
case controllers_NewUserController_addUserToGroupAsAdmin43_route(params) => {
   call { 
        controllers_NewUserController_addUserToGroupAsAdmin43_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addUserToGroupAsAdmin)
   }
}
        

// @LINE:68
case controllers_NewUserController_addUserToGroupAsMember44_route(params) => {
   call { 
        controllers_NewUserController_addUserToGroupAsMember44_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addUserToGroupAsMember)
   }
}
        

// @LINE:69
case controllers_NewUserController_addFriendToUser45_route(params) => {
   call { 
        controllers_NewUserController_addFriendToUser45_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addFriendToUser)
   }
}
        

// @LINE:70
case controllers_NewUserController_addSubscribeUserToUser46_route(params) => {
   call { 
        controllers_NewUserController_addSubscribeUserToUser46_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addSubscribeUserToUser)
   }
}
        

// @LINE:71
case controllers_NewUserController_addSubscribeGroupToUser47_route(params) => {
   call { 
        controllers_NewUserController_addSubscribeGroupToUser47_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addSubscribeGroupToUser)
   }
}
        

// @LINE:72
case controllers_NewUserController_addSubscribeWorkflowToUser48_route(params) => {
   call { 
        controllers_NewUserController_addSubscribeWorkflowToUser48_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).addSubscribeWorkflowToUser)
   }
}
        

// @LINE:73
case controllers_NewUserController_deleteUser49_route(params) => {
   call { 
        controllers_NewUserController_deleteUser49_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteUser)
   }
}
        

// @LINE:74
case controllers_NewUserController_deleteUserByUserNameAndPassword50_route(params) => {
   call { 
        controllers_NewUserController_deleteUserByUserNameAndPassword50_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteUserByUserNameAndPassword)
   }
}
        

// @LINE:75
case controllers_NewUserController_deleteContributorFromWorkflow51_route(params) => {
   call { 
        controllers_NewUserController_deleteContributorFromWorkflow51_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteContributorFromWorkflow)
   }
}
        

// @LINE:76
case controllers_NewUserController_deleteUserFromGroup52_route(params) => {
   call { 
        controllers_NewUserController_deleteUserFromGroup52_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteUserFromGroup)
   }
}
        

// @LINE:77
case controllers_NewUserController_deleteFriendFromUser53_route(params) => {
   call { 
        controllers_NewUserController_deleteFriendFromUser53_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteFriendFromUser)
   }
}
        

// @LINE:78
case controllers_NewUserController_deleteSubscribeUserFromUser54_route(params) => {
   call { 
        controllers_NewUserController_deleteSubscribeUserFromUser54_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteSubscribeUserFromUser)
   }
}
        

// @LINE:79
case controllers_NewUserController_deleteSubscribeGroupFromUser55_route(params) => {
   call { 
        controllers_NewUserController_deleteSubscribeGroupFromUser55_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteSubscribeGroupFromUser)
   }
}
        

// @LINE:80
case controllers_NewUserController_deleteSubscribeWorkflowFromUser56_route(params) => {
   call { 
        controllers_NewUserController_deleteSubscribeWorkflowFromUser56_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).deleteSubscribeWorkflowFromUser)
   }
}
        

// @LINE:81
case controllers_NewUserController_updateUser57_route(params) => {
   call { 
        controllers_NewUserController_updateUser57_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).updateUser)
   }
}
        

// @LINE:82
case controllers_NewUserController_getUser58_route(params) => {
   call { 
        controllers_NewUserController_getUser58_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getUser)
   }
}
        

// @LINE:83
case controllers_NewUserController_getUserIdByUserName59_route(params) => {
   call { 
        controllers_NewUserController_getUserIdByUserName59_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getUserIdByUserName)
   }
}
        

// @LINE:84
case controllers_NewUserController_getUserIdByEmail60_route(params) => {
   call { 
        controllers_NewUserController_getUserIdByEmail60_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getUserIdByEmail)
   }
}
        

// @LINE:85
case controllers_NewUserController_getAllUsers61_route(params) => {
   call { 
        controllers_NewUserController_getAllUsers61_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getAllUsers)
   }
}
        

// @LINE:86
case controllers_NewUserController_getSubscribersNumber62_route(params) => {
   call { 
        controllers_NewUserController_getSubscribersNumber62_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getSubscribersNumber)
   }
}
        

// @LINE:87
case controllers_NewUserController_getCollaboratorsNumber63_route(params) => {
   call { 
        controllers_NewUserController_getCollaboratorsNumber63_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewUserController]).getCollaboratorsNumber)
   }
}
        

// @LINE:90
case controllers_NewWorkflowController_addWorkflow64_route(params) => {
   call { 
        controllers_NewWorkflowController_addWorkflow64_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).addWorkflow)
   }
}
        

// @LINE:91
case controllers_NewWorkflowController_addAttributeWorkflowToWorkflow65_route(params) => {
   call { 
        controllers_NewWorkflowController_addAttributeWorkflowToWorkflow65_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).addAttributeWorkflowToWorkflow)
   }
}
        

// @LINE:92
case controllers_NewWorkflowController_deleteWorkflow66_route(params) => {
   call { 
        controllers_NewWorkflowController_deleteWorkflow66_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteWorkflow)
   }
}
        

// @LINE:93
case controllers_NewWorkflowController_deleteWorkflowByName67_route(params) => {
   call { 
        controllers_NewWorkflowController_deleteWorkflowByName67_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteWorkflowByName)
   }
}
        

// @LINE:94
case controllers_NewWorkflowController_deleteAttributeWorkflowFromWorkflow68_route(params) => {
   call { 
        controllers_NewWorkflowController_deleteAttributeWorkflowFromWorkflow68_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteAttributeWorkflowFromWorkflow)
   }
}
        

// @LINE:95
case controllers_NewWorkflowController_updateWorkflow69_route(params) => {
   call { 
        controllers_NewWorkflowController_updateWorkflow69_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).updateWorkflow)
   }
}
        

// @LINE:96
case controllers_NewWorkflowController_getWorkflow70_route(params) => {
   call { 
        controllers_NewWorkflowController_getWorkflow70_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getWorkflow)
   }
}
        

// @LINE:97
case controllers_NewWorkflowController_getWorkflowIdByName71_route(params) => {
   call { 
        controllers_NewWorkflowController_getWorkflowIdByName71_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getWorkflowIdByName)
   }
}
        

// @LINE:98
case controllers_NewWorkflowController_getAllWorkflows72_route(params) => {
   call { 
        controllers_NewWorkflowController_getAllWorkflows72_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getAllWorkflows)
   }
}
        

// @LINE:99
case controllers_NewWorkflowController_getWorkflowPopularity73_route(params) => {
   call { 
        controllers_NewWorkflowController_getWorkflowPopularity73_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).getWorkflowPopularity)
   }
}
        

// @LINE:101
case controllers_NewWorkflowController_addTagToWorkflow74_route(params) => {
   call { 
        controllers_NewWorkflowController_addTagToWorkflow74_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).addTagToWorkflow)
   }
}
        

// @LINE:102
case controllers_NewWorkflowController_deleteTagFromWorkflow75_route(params) => {
   call { 
        controllers_NewWorkflowController_deleteTagFromWorkflow75_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewWorkflowController]).deleteTagFromWorkflow)
   }
}
        

// @LINE:105
case controllers_NewTaskController_addTask76_route(params) => {
   call { 
        controllers_NewTaskController_addTask76_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).addTask)
   }
}
        

// @LINE:106
case controllers_NewTaskController_addTaskToWorkflow77_route(params) => {
   call { 
        controllers_NewTaskController_addTaskToWorkflow77_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).addTaskToWorkflow)
   }
}
        

// @LINE:107
case controllers_NewTaskController_deleteTask78_route(params) => {
   call { 
        controllers_NewTaskController_deleteTask78_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).deleteTask)
   }
}
        

// @LINE:108
case controllers_NewTaskController_updateTask79_route(params) => {
   call { 
        controllers_NewTaskController_updateTask79_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).updateTask)
   }
}
        

// @LINE:109
case controllers_NewTaskController_getTask80_route(params) => {
   call { 
        controllers_NewTaskController_getTask80_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTaskController]).getTask)
   }
}
        

// @LINE:112
case controllers_NewInputController_addInput81_route(params) => {
   call { 
        controllers_NewInputController_addInput81_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).addInput)
   }
}
        

// @LINE:113
case controllers_NewInputController_addInputToWorkflow82_route(params) => {
   call { 
        controllers_NewInputController_addInputToWorkflow82_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).addInputToWorkflow)
   }
}
        

// @LINE:114
case controllers_NewInputController_deleteInput83_route(params) => {
   call { 
        controllers_NewInputController_deleteInput83_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).deleteInput)
   }
}
        

// @LINE:115
case controllers_NewInputController_updateInput84_route(params) => {
   call { 
        controllers_NewInputController_updateInput84_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).updateInput)
   }
}
        

// @LINE:116
case controllers_NewInputController_getInput85_route(params) => {
   call { 
        controllers_NewInputController_getInput85_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInputController]).getInput)
   }
}
        

// @LINE:119
case controllers_NewOutputController_addOutput86_route(params) => {
   call { 
        controllers_NewOutputController_addOutput86_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).addOutput)
   }
}
        

// @LINE:120
case controllers_NewOutputController_addOutputToWorkflow87_route(params) => {
   call { 
        controllers_NewOutputController_addOutputToWorkflow87_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).addOutputToWorkflow)
   }
}
        

// @LINE:121
case controllers_NewOutputController_deleteOutput88_route(params) => {
   call { 
        controllers_NewOutputController_deleteOutput88_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).deleteOutput)
   }
}
        

// @LINE:122
case controllers_NewOutputController_updateOutput89_route(params) => {
   call { 
        controllers_NewOutputController_updateOutput89_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).updateOutput)
   }
}
        

// @LINE:123
case controllers_NewOutputController_getOutput90_route(params) => {
   call { 
        controllers_NewOutputController_getOutput90_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewOutputController]).getOutput)
   }
}
        

// @LINE:126
case controllers_NewInstructionController_addInstruction91_route(params) => {
   call { 
        controllers_NewInstructionController_addInstruction91_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).addInstruction)
   }
}
        

// @LINE:127
case controllers_NewInstructionController_addInstructionToWorkflow92_route(params) => {
   call { 
        controllers_NewInstructionController_addInstructionToWorkflow92_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).addInstructionToWorkflow)
   }
}
        

// @LINE:128
case controllers_NewInstructionController_deleteInstruction93_route(params) => {
   call { 
        controllers_NewInstructionController_deleteInstruction93_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).deleteInstruction)
   }
}
        

// @LINE:129
case controllers_NewInstructionController_updateInstruction94_route(params) => {
   call { 
        controllers_NewInstructionController_updateInstruction94_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).updateInstruction)
   }
}
        

// @LINE:130
case controllers_NewInstructionController_getInstruction95_route(params) => {
   call { 
        controllers_NewInstructionController_getInstruction95_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewInstructionController]).getInstruction)
   }
}
        

// @LINE:133
case controllers_NewDatasetController_addDataset96_route(params) => {
   call { 
        controllers_NewDatasetController_addDataset96_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).addDataset)
   }
}
        

// @LINE:134
case controllers_NewDatasetController_addDatasetToWorkflow97_route(params) => {
   call { 
        controllers_NewDatasetController_addDatasetToWorkflow97_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).addDatasetToWorkflow)
   }
}
        

// @LINE:135
case controllers_NewDatasetController_deleteDataset98_route(params) => {
   call { 
        controllers_NewDatasetController_deleteDataset98_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).deleteDataset)
   }
}
        

// @LINE:136
case controllers_NewDatasetController_updateDataset99_route(params) => {
   call { 
        controllers_NewDatasetController_updateDataset99_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).updateDataset)
   }
}
        

// @LINE:137
case controllers_NewDatasetController_getDataset100_route(params) => {
   call { 
        controllers_NewDatasetController_getDataset100_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewDatasetController]).getDataset)
   }
}
        

// @LINE:140
case controllers_NewLinkController_addLink101_route(params) => {
   call { 
        controllers_NewLinkController_addLink101_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).addLink)
   }
}
        

// @LINE:141
case controllers_NewLinkController_addLinkToWorkflow102_route(params) => {
   call { 
        controllers_NewLinkController_addLinkToWorkflow102_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).addLinkToWorkflow)
   }
}
        

// @LINE:142
case controllers_NewLinkController_deleteLink103_route(params) => {
   call { 
        controllers_NewLinkController_deleteLink103_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).deleteLink)
   }
}
        

// @LINE:143
case controllers_NewLinkController_updateLink104_route(params) => {
   call { 
        controllers_NewLinkController_updateLink104_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).updateLink)
   }
}
        

// @LINE:144
case controllers_NewLinkController_getLink105_route(params) => {
   call { 
        controllers_NewLinkController_getLink105_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewLinkController]).getLink)
   }
}
        

// @LINE:147
case controllers_NewGroupController_addGroup106_route(params) => {
   call { 
        controllers_NewGroupController_addGroup106_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).addGroup)
   }
}
        

// @LINE:148
case controllers_NewGroupController_deleteGroup107_route(params) => {
   call { 
        controllers_NewGroupController_deleteGroup107_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).deleteGroup)
   }
}
        

// @LINE:149
case controllers_NewGroupController_updateGroup108_route(params) => {
   call { 
        controllers_NewGroupController_updateGroup108_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).updateGroup)
   }
}
        

// @LINE:150
case controllers_NewGroupController_getGroup109_route(params) => {
   call { 
        controllers_NewGroupController_getGroup109_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).getGroup)
   }
}
        

// @LINE:151
case controllers_NewGroupController_getGroupIdByName110_route(params) => {
   call { 
        controllers_NewGroupController_getGroupIdByName110_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).getGroupIdByName)
   }
}
        

// @LINE:152
case controllers_NewGroupController_getAllGroups111_route(params) => {
   call { 
        controllers_NewGroupController_getAllGroups111_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewGroupController]).getAllGroups)
   }
}
        

// @LINE:155
case controllers_NewTagController_addTag112_route(params) => {
   call { 
        controllers_NewTagController_addTag112_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).addTag)
   }
}
        

// @LINE:156
case controllers_NewTagController_deleteTag113_route(params) => {
   call { 
        controllers_NewTagController_deleteTag113_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).deleteTag)
   }
}
        

// @LINE:157
case controllers_NewTagController_updateTag114_route(params) => {
   call { 
        controllers_NewTagController_updateTag114_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).updateTag)
   }
}
        

// @LINE:158
case controllers_NewTagController_getTag115_route(params) => {
   call { 
        controllers_NewTagController_getTag115_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).getTag)
   }
}
        

// @LINE:159
case controllers_NewTagController_getTagIdByName116_route(params) => {
   call { 
        controllers_NewTagController_getTagIdByName116_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).getTagIdByName)
   }
}
        

// @LINE:160
case controllers_NewTagController_getAllTags117_route(params) => {
   call { 
        controllers_NewTagController_getAllTags117_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewTagController]).getAllTags)
   }
}
        

// @LINE:163
case controllers_NewPostController_addPost118_route(params) => {
   call { 
        controllers_NewPostController_addPost118_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).addPost)
   }
}
        

// @LINE:164
case controllers_NewPostController_addPostToUser119_route(params) => {
   call { 
        controllers_NewPostController_addPostToUser119_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).addPostToUser)
   }
}
        

// @LINE:165
case controllers_NewPostController_addTagToPost120_route(params) => {
   call { 
        controllers_NewPostController_addTagToPost120_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).addTagToPost)
   }
}
        

// @LINE:166
case controllers_NewPostController_deletePost121_route(params) => {
   call { 
        controllers_NewPostController_deletePost121_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).deletePost)
   }
}
        

// @LINE:167
case controllers_NewPostController_deleteTagFromPost122_route(params) => {
   call { 
        controllers_NewPostController_deleteTagFromPost122_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).deleteTagFromPost)
   }
}
        

// @LINE:168
case controllers_NewPostController_updatePost123_route(params) => {
   call { 
        controllers_NewPostController_updatePost123_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).updatePost)
   }
}
        

// @LINE:169
case controllers_NewPostController_getPost124_route(params) => {
   call { 
        controllers_NewPostController_getPost124_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).getPost)
   }
}
        

// @LINE:170
case controllers_NewPostController_getPostsUnderDomainAndDomainName125_route(params) => {
   call { 
        controllers_NewPostController_getPostsUnderDomainAndDomainName125_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewPostController]).getPostsUnderDomainAndDomainName)
   }
}
        

// @LINE:173
case controllers_NewReplyController_addReply126_route(params) => {
   call { 
        controllers_NewReplyController_addReply126_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).addReply)
   }
}
        

// @LINE:174
case controllers_NewReplyController_addReplyToPost127_route(params) => {
   call { 
        controllers_NewReplyController_addReplyToPost127_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).addReplyToPost)
   }
}
        

// @LINE:175
case controllers_NewReplyController_deleteReply128_route(params) => {
   call { 
        controllers_NewReplyController_deleteReply128_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).deleteReply)
   }
}
        

// @LINE:176
case controllers_NewReplyController_updateReply129_route(params) => {
   call { 
        controllers_NewReplyController_updateReply129_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).updateReply)
   }
}
        

// @LINE:177
case controllers_NewReplyController_getReply130_route(params) => {
   call { 
        controllers_NewReplyController_getReply130_invoker.call(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.NewReplyController]).getReply)
   }
}
        
}

}
     