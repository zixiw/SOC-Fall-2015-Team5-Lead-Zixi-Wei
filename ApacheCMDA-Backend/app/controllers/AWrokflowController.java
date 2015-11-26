package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mingyangling on 11/17/15.
 */
@Named
@Singleton
public class AWrokflowController extends Controller {

    private final AWorkflowRepository aWorkflowRepository;
    private final AUserRepository aUserRepository;

    @Inject
    public AWrokflowController(final AWorkflowRepository aWorkflowRepository, AUserRepository aUserRepository) {
        this.aWorkflowRepository = aWorkflowRepository;
        this.aUserRepository = aUserRepository;
    }


    public Result addWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Task not created, expecting Json data");
            return badRequest("Task not created, expecting Json data");
        }

        String name = json.path("name").asText();
        String description = json.path("description").asText();
        String previewImage = json.path("previewImage").asText();
        JsonNode tasks = json.path("tasks");
        JsonNode inputs = json.path("inputs");
        JsonNode outputs = json.path("outputs");
        JsonNode contributors = json.path("contributors");
        JsonNode tags = json.path("tags");
        JsonNode links = json.path("links");
        JsonNode instruments = json.path("instruments");
        JsonNode associatedDatasets = json.path("associatedDatasets");
        JsonNode associateWorkflow = json.path("associateWorkflow");

        try {
            if (aWorkflowRepository.findFirstByName(name) != null) {
                System.out.println("Name existed: " + name);
                return badRequest("Name existed");
            }
            AWorkflow workflow = new AWorkflow();
            workflow.setName(name);
            workflow.setDescription(description);
            workflow.setPreviewImage(previewImage);
            // set task
            Set<ATask> taskSet = new HashSet<ATask>();
            for (int i = 0; i < tasks.size(); i++) {
                JsonNode task = tasks.get(i);
                String taskname= task.path("name").asText();
                String taskcontent=task.path("content").asText();
                taskSet.add(new ATask(taskname,taskcontent,workflow ));
            }
            workflow.setTasks(taskSet);
            // set input
            Set<AInput> inputSet = new HashSet<AInput>();
            for (int i = 0; i < inputs.size(); i++) {
                JsonNode input = inputs.get(i);
                String inputname= input.path("name").asText();
                String inputcontent=input.path("content").asText();
                inputSet.add(new AInput(inputname,inputcontent,workflow ));
            }
            workflow.setInputs(inputSet);
            // set output
            Set<AOutput> outputSet = new HashSet<AOutput>();
            for (int i = 0; i < outputs.size(); i++) {
                JsonNode output = outputs.get(i);
                String outputname= output.path("name").asText();
                String outputcontent=output.path("content").asText();
                outputSet.add(new AOutput(outputname,outputcontent,workflow ));
            }
            workflow.setOutputs(outputSet);
            // set contributors
            Set<AUser> userSet = new HashSet<AUser>();
            for (int i = 0; i < contributors.size(); i++) {
                JsonNode user = contributors.get(i);
                String userName= user.path("userName").asText();
//                String firstName= user.path("firstName").asText();
//                String lastName= user.path("lastName").asText();
//                String middleInitial= user.path("middleInitial").asText();
//                String affiliation= user.path("affiliation").asText();
//                String title= user.path("title").asText();
//                String email= user.path("email").asText();
//                String mailingAddress= user.path("mailingAddress").asText();
//                String phoneNumber= user.path("phoneNumber").asText();
//                String faxNumber= user.path("faxNumber").asText();
//                String researchFields= user.path("researchFields").asText();
//                String highestDegree= user.path("highestDegree").asText();
//                String password = "";
                AUser tempuser = null;
                AUser aUser = null;
                if (aUserRepository.findFirstByUserName(userName) != null) {
                    tempuser = aUserRepository.findFirstByUserName(userName);
                    aUserRepository.delete(tempuser);
                }
                if (tempuser == null) {
                    //userSet.add(new AUser(userName, password,firstName, lastName, middleInitial, affiliation, title, email, mailingAddress, phoneNumber, faxNumber, researchFields, highestDegree, workflow ));
                    System.out.println("cannot find contributor's userName: " + userName);
                    return badRequest("cannot find contributor's userName: " + userName);
                } else {
                    aUser = new AUser(userName, tempuser.getPassword(),tempuser.getFirstName(), tempuser.getLastName(), tempuser.getMiddleInitial(), tempuser.getAffiliation(), tempuser.getTitle(), tempuser.getEmail(), tempuser.getMailingAddress(), tempuser.getPhoneNumber(), tempuser.getFaxNumber(), tempuser.getResearchFields(), tempuser.getHighestDegree(), workflow , null);
                    userSet.add(aUser);
                    aUserRepository.delete(tempuser);
                }
                aUserRepository.delete(tempuser);
                //aUserRepository.save(new AUser(userName, password,firstName, lastName, middleInitial, affiliation, title, email, mailingAddress, phoneNumber, faxNumber, researchFields, highestDegree, workflow ));
            }
            workflow.setContributors(userSet);
            // set tags
            Set<ATag> tagSet = new HashSet<ATag>();
            for (int i = 0; i < tags.size(); i++) {
                JsonNode tag = tags.get(i);
                String tagcontent=tag.path("content").asText();
                tagSet.add(new ATag(tagcontent, workflow ));
            }
            workflow.setTags(tagSet);
            // set links
            Set<ALink> linkSet = new HashSet<ALink>();
            for (int i = 0; i < links.size(); i++) {
                JsonNode link = links.get(i);
                String linkcontent=link.path("content").asText();
                linkSet.add(new ALink(linkcontent, workflow ));
            }
            workflow.setLinks(linkSet);
            // set instruments
            Set<AInstrument> AInstrumentSet = new HashSet<AInstrument>();
            for (int i = 0; i < instruments.size(); i++) {
                JsonNode instrument = instruments.get(i);
                String instrumentname=instrument.path("name").asText();
                String instrumentcontent=instrument.path("content").asText();
                AInstrumentSet.add(new AInstrument(instrumentname, instrumentcontent, workflow ));
            }
            workflow.setInstruments(AInstrumentSet);
            // set associatedDatasets
            Set<ADataset> DataSet = new HashSet<ADataset>();
            for (int i = 0; i < associatedDatasets.size(); i++) {
                JsonNode dataset = associatedDatasets.get(i);
                String datasetname=dataset.path("name").asText();
                String datasetcontent=dataset.path("content").asText();
                DataSet.add(new ADataset(datasetname, datasetcontent, workflow ));
            }
            workflow.setAssociatedDatasets(DataSet);
            // set associateWorkflow
            Set<AAssociateWorkflow> associateWorkflowsSet = new HashSet<AAssociateWorkflow>();
            for (int i = 0; i < associateWorkflow.size(); i++) {
                JsonNode aworkfl = associateWorkflow.get(i);
                String datasetname=aworkfl.path("name").asText();
                associateWorkflowsSet.add(new AAssociateWorkflow(datasetname, workflow ));
            }
            workflow.setAssociateWorkflow(associateWorkflowsSet);
            aWorkflowRepository.save(workflow);
            System.out.println("workflow successfully received");
            return ok("workflow successfully received");
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Page not saved: " + name);
            return badRequest("Page not saved: " + name);
        }
    }

//    public Result updateTag() {
//        JsonNode json = request().body().asJson();
//        if (json == null) {
//            System.out.println("Task not created, expecting Json data");
//            return badRequest("Task not created, expecting Json data");
//        }
//        String name = json.path("name").asText();
//        JsonNode tags = json.path("tag");
//
//        try {
//            Atest atest = atestRepository.findFirstByName(name);
//            if (atest == null) {
//                System.out.println("Name not exised: " + name);
//                return badRequest("Name not existed");
//            }
////            List<Btest> list=btestRepository.findByAtest(atest);
//            atest.getTests().clear();
////            for(Btest b: list){
////                System.out.println(b.getName());
////                btestRepository.delete(b);
////            }
//            for (int i = 0; i < tags.size(); i++) {
//                String tag = tags.get(i).asText();
//                atest.getTests().add(new Btest(tag, atest));
//            }
//
//            atestRepository.save(atest);
//            System.out.println("Page saved: " + atest.toString());
//            return created(new Gson().toJson(atest.toString()));
//        } catch (PersistenceException pe) {
//            pe.printStackTrace();
//            System.out.println("Page not saved: " + name);
//            return badRequest("Page not saved: " + name);
//        }
//
//    }


    public Result getWorkflow(String name) {
        try {
            AWorkflow aWorkflow = aWorkflowRepository.findFirstByName(name);
            if (aWorkflow == null) {
                System.out.println("Name not existed: " + name);
                return badRequest("Name not existed");
            }

//            JsonObject jsonObject = new JsonObject();
//
//            jsonObject.addProperty("name", aWorkflow.getName());
//            jsonObject.addProperty("description", aWorkflow.getDescription());
//            jsonObject.addProperty("previewImage", aWorkflow.getPreviewImage());
//
//            // get task
//            JsonArray jsonArrayATask = new JsonArray();
//            for (ATask task : aWorkflow.getTasks()) {
//                jsonArrayATask.add(task.toJson());
//            }
//            jsonObject.add("tasks", jsonArrayATask);
//            // get input
//            JsonArray jsonArrayAInput = new JsonArray();
//            for (AInput input : aWorkflow.getInputs()) {
//                jsonArrayAInput.add(input.toJson());
//            }
//            jsonObject.add("inputs", jsonArrayAInput);
//            // get output
//            JsonArray jsonArrayAOutput = new JsonArray();
//            for (AOutput output : aWorkflow.getOutputs()) {
//                jsonArrayAOutput.add(output.toJson());
//            }
//            jsonObject.add("output", jsonArrayAOutput);
//            // get contributors
//            JsonArray jsonArrayAUser = new JsonArray();
//            for (AUser user : aWorkflow.getContributors()) {
//                jsonArrayAUser.add(user.toJson());
//            }
//            jsonObject.add("contributors", jsonArrayAUser);
//            // get tags
//            JsonArray jsonArrayATag = new JsonArray();
//            for (ATag tag : aWorkflow.getTags()) {
//                jsonArrayATag.add(tag.toJson());
//            }
//            jsonObject.add("tags", jsonArrayATag);
//            // get links
//            JsonArray jsonArrayALink = new JsonArray();
//            for (ALink link : aWorkflow.getLinks()) {
//                jsonArrayALink.add(link.toJson());
//            }
//            jsonObject.add("links", jsonArrayALink);
//            // get instruments
//            JsonArray jsonArrayAInstrument = new JsonArray();
//            for (AInstrument instrument : aWorkflow.getInstruments()) {
//                jsonArrayAInstrument.add(instrument.toJson());
//            }
//            jsonObject.add("instruments", jsonArrayAInstrument);
//            // get associatedDatasets
//            JsonArray jsonArrayADataset = new JsonArray();
//            for (ADataset dataset : aWorkflow.getAssociatedDatasets()) {
//                jsonArrayADataset.add(dataset.toJson());
//            }
//            jsonObject.add("associatedDatasets", jsonArrayADataset);
//            // get associateWorkflow
//            JsonArray jsonArrayAAssociateWorkflow = new JsonArray();
//            for (AAssociateWorkflow associateWorkflow : aWorkflow.getAssociateWorkflow()) {
//                jsonArrayAAssociateWorkflow.add(associateWorkflow.toJson());
//            }
//            jsonObject.add("associateWorkflow", jsonArrayAAssociateWorkflow);
            return created(aWorkflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("getAtest: " + name);
            return badRequest("getAtest " + name);
        }
    }
}
