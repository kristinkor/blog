package com.kristinblog.blog.controller;

import com.kristinblog.blog.JsonFileReader;
import com.kristinblog.blog.models.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @GetMapping("/getProjectHtml")
    public String getProjectHtml() {
        List<Project> projects = JsonFileReader.readProjectData();
        String generatedHtml = generateProjectHtml(projects);
        return generatedHtml;
    }

    public static String generateProjectHtml(List<Project> projects) {
        if (projects == null || projects.isEmpty()) {
            return ""; // Handle the error gracefully
        }

        StringBuilder htmlBuilder = new StringBuilder();

        for (Project project : projects) {
            htmlBuilder.append("<div class=\"col-lg-4 col-md-6 picture-item shuffle-item shuffle-item--visible\" data-groups=\"[");

            // Add data-groups information based on your project's categories, for example:
            if (project.getBadges() != null && !project.getBadges().isEmpty()) {
                String categories = String.join(", ", project.getBadges());
                htmlBuilder.append("\"").append(categories).append("\"");
            }

            htmlBuilder.append("]\">");
            htmlBuilder.append("<div class=\"card rounded shadow border-0 m-2\">");
            htmlBuilder.append("<div class=\"card-body p-4 m-2\">");

            // Add the project's image, title, link, and other information here
            htmlBuilder.append("<div class=\"media mb-3\">");
            htmlBuilder.append("<div class=\"bg-soft-alt-orange d-flex justify-content-center align-items-center thumb-xl rounded\">");
            htmlBuilder.append("<img src=\"").append(project.getImageUrl()).append("\" alt=\"\" class=\"thumb-md\">");
            htmlBuilder.append("</div>");
            htmlBuilder.append("<div class=\"media-body ms-3 align-self-center\">");
            htmlBuilder.append("<h5 class=\"text-dark fs-18 fw-medium m-0\">").append(project.getTitle()).append("</h5>");
            htmlBuilder.append("<p class=\"text-muted mb-0 fs-13\"><a href=\"").append(project.getProjectLink()).append("\">");
            htmlBuilder.append("<p>").append(project.getDescription()).append("</p>");
            htmlBuilder.append("</div><!--end media-body-->");
            htmlBuilder.append("</div><!--end media-->");

            // Add badges based on your project's badges
            if (project.getBadges() != null && !project.getBadges().isEmpty()) {
                for (String badge : project.getBadges()) {
                    htmlBuilder.append("<span class=\"badge badge-lg rounded bg-soft-alt-info fw-normal fs-12 text-uppercase\">").append(badge).append("</span>");
                }
            }

            htmlBuilder.append("</div><!-- end card-body -->");
            htmlBuilder.append("</div><!-- end card -->");
            htmlBuilder.append("</div><!-- end col -->");
        }

        return htmlBuilder.toString();
    }



}
