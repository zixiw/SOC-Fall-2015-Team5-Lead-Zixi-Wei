package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 12/1/15.
 */
@Named
@Singleton
public class NewLinkController extends Controller {
    private final NewLinkRepository newLinkRepository;
    private final NewWorkflowRepository newWorkflowRepository;

    @Inject
    public NewLinkController(final NewLinkRepository newLinkRepository,
                             final NewWorkflowRepository newWorkflowRepository) {
        this.newLinkRepository = newLinkRepository;
        this.newWorkflowRepository = newWorkflowRepository;
    }

    // add
    public Result addLink() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add link failed, expecting Json data");
            return badRequest("Add link failed, expecting Json data");
        }

        String source = json.path("source").asText();
        String sink = json.path("sink").asText();

        try {
            NewLink link = new NewLink(source, sink);
            NewLink savedLink = newLinkRepository.save(link);
            System.out.println("Add link success: " + savedLink.getId());
            return created(savedLink.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add link failed: " + source);
            return badRequest("Add link failed: " + source);
        }
    }

    public Result addLinkToWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add link to Workflow failed, expecting Json data");
            return badRequest("Add link to Workflow failed, expecting Json data");
        }

        long linkId = json.path("linkId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewLink link = newLinkRepository.findOne(linkId);
        if (link == null) {
            System.out.println("Link not found with id: " + linkId);
            return notFound("Link not found with id: " + linkId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        List<NewLink> workflowsLinks = workflow.getNewLinks();
        for (NewLink workflowsLink : workflowsLinks) {
            if (workflowsLink.getId() == linkId) {
                System.out.println("Add link failed, link id " + linkId + " has existed in workflow id: " + workflowId);
                return badRequest("Add link failed, link id " + linkId + " has existed in workflow id: " + workflowId);
            }
        }

        // set up the link
        link.setNewWorkflow(workflow);

        try {
            newLinkRepository.save(link);
            System.out.println("Add link to Workflow success");
            workflow = newWorkflowRepository.findOne(workflowId);
            return created(workflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add link to Workflow failed, link id: " + linkId + " workflow id: " + workflowId);
            return badRequest("Add link to Workflow failed, link id: " + linkId + " workflow id: " + workflowId);
        }
    }

    // delete
    public Result deleteLink() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete link failed, expecting Json data");
            return badRequest("Delete link failed, expecting Json data");
        }

        long id = json.path("linkId").asLong();

        NewLink link = newLinkRepository.findOne(id);
        if (link == null) {
            System.out.println("Link not found with id: " + id);
            return notFound("Link not found with id: " + id);
        }

        newLinkRepository.delete(link);

        System.out.println("Delete link success: " + id);
        return ok("Delete link success: " + id);
    }

    // update
    public Result updateLink() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update link failed, expecting Json data");
            return badRequest("Update link failed, expecting Json data");
        }

        long id = json.path("linkId").asLong();
        String source = json.path("source").asText();
        String sink = json.path("sink").asText();

        NewLink link = newLinkRepository.findOne(id);
        if (link == null) {
            System.out.println("Link not found with id: " + id);
            return notFound("Link not found with id: " + id);
        }

        try {
            link.setSource(source);
            link.setSink(sink);

            NewLink savedLink = newLinkRepository.save(link);
            System.out.println("Update link success: " + savedLink.getId());
            return created(savedLink.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update link failed: " + id);
            return badRequest("Update link failed: " + id);
        }
    }

    // get
    public Result getLink() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get link failed, expecting Json data");
            return badRequest("Get link failed, expecting Json data");
        }

        long id = json.path("linkId").asLong();

        NewLink link = newLinkRepository.findOne(id);
        if (link == null) {
            System.out.println("Link not found with id: " + id);
            return notFound("Link not found with id: " + id);
        }

        return created(link.toJson().toString());
    }
}
