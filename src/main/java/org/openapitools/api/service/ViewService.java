package org.openapitools.api.service;

import org.openapitools.api.ViewApiDelegate;
import org.openapitools.model.ViewData;
import org.openapitools.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ViewService implements ViewApiDelegate {

    private final List<ViewData> view_List = new ArrayList<>();
    public ViewService() {
        // Initialize the categoryList with some sample categories
        ViewData test1 = new ViewData();
        test1.setTitle("TEST");
        test1.setDay(Integer.valueOf("1"));
        test1.setYear(Integer.valueOf("2021"));
        test1.setHour(Integer.valueOf("1"));
        test1.setMinute(Integer.valueOf("1"));
        test1.setDescription("TEST");
        test1.setSelectedStatus("Draft");
        test1.setSelectedCategories(Arrays.asList("Fantasy", "Sci-Fi"));
        test1.setSelectedMonth("Jan");
        test1.setId("TEST-01/Jan/2021-01:01");
        view_List.add(test1);
    }

    @Override
    //get all the view data
    public ResponseEntity<List<ViewData>> viewGet() {

        return ResponseEntity.ok(view_List);
    }

    @Override
    public ResponseEntity<ViewData> viewViewdataPost(
            @NotNull String title,
            @NotNull Integer day,
            @NotNull String SelectedMonth,
            @NotNull Integer year,
            @NotNull Integer hour,
            @NotNull Integer minute,
            @NotNull String description,
            @NotNull List<String> selectedCategories,
            @NotNull String selectedStatus) {

        // Validate the date
        LocalDate date = validateDate(day, SelectedMonth, year);

        // Validate the time
        LocalTime time = validateTime(hour, minute);

        validateStatus(selectedStatus);

        // Create the blog object with the input values
        ViewData blog = new ViewData();
        // Generate the ID based on the provided values
        String id = generateId(title, date, time);
        blog.setId(id);
        blog.setTitle(title);
        blog.setDay(day);
        blog.setYear(year);
        blog.setHour(hour);
        blog.setMinute(minute);
        blog.setDescription(description);
        blog.setSelectedMonth(SelectedMonth)  ;
        blog.setSelectedCategories(selectedCategories);
        blog.setSelectedStatus(selectedStatus);
        System.out.println(selectedCategories);

        view_List.add(blog);

        // Perform further processing or save the blog object

        return ResponseEntity.status(HttpStatus.CREATED).body(blog);
    }

    public ViewData getViewDataById(String id) {
        for (ViewData viewData : view_List) {
            //print in console
            System.out.println("getViewDataById");
            if (viewData.getId().equals(id)) {
                return viewData;
            }
        }
        throw new IllegalArgumentException("ViewData not found for ID: " + id);
    }

    public void updateViewData(ViewData viewData, String id) {
        for (int i = 0; i < view_List.size(); i++) {
            if (view_List.get(i).getId().equals(id)) {
                view_List.set(i, viewData);
                return;
            }
        }
        throw new IllegalArgumentException("ViewData not found for ID: " + viewData.getId());
    }

    public LocalDate validateDate(Integer day, String selectedMonthCode, Integer year) {
        try {
            int dayValue = day;
            int yearValue = year;
            int monthIndex = getMonthIndex(selectedMonthCode);

            // Validate the day
            if (dayValue < 1 || dayValue > 31) {
                throw new IllegalArgumentException("Invalid day");
            }

            // Validate the month index
            if (monthIndex < 0 || monthIndex > 11) {
                throw new IllegalArgumentException("Invalid month code");
            }

            // Validate the year
            if (yearValue < 0) {
                throw new IllegalArgumentException("Invalid year");
            }

            // Validate the date using LocalDate
            return LocalDate.of(yearValue, monthIndex + 1, dayValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    public LocalTime validateTime(Integer hour, Integer minute) {
        try {
            int hourValue = hour;
            int minuteValue = minute;

            // Validate the hour
            if (hourValue < 0 || hourValue > 23) {
                throw new IllegalArgumentException("Invalid hour");
            }

            // Validate the minute
            if (minuteValue < 0 || minuteValue > 59) {
                throw new IllegalArgumentException("Invalid minute");
            }

            // Validate the time using LocalTime
            return LocalTime.of(hourValue, minuteValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid time format");
        }
    }

    public String generateId(String title, LocalDate date, LocalTime time) {
        // Generate the ID based on the provided values
        String formattedTitle = title.trim().replaceAll("\\s+", " ");
        String formattedMonth = date.getMonth().name();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd"));
        String formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm"));
        return formattedTitle + "-" + formattedDate + "/" + formattedMonth + "/" + date.getYear() + "-" + formattedTime;
    }

    private List<Month> getMonths() {
        // Return the list of months for the dropdown
        return Arrays.asList(
                new Month("Jan"),
                new Month("Feb"),
                new Month("Mar"),
                new Month("Apr"),
                new Month("May"),
                new Month("Jun"),
                new Month("Jul"),
                new Month("Aug"),
                new Month("Sep"),
                new Month("Oct"),
                new Month("Nov"),
                new Month("Dec")
        );
    }

    public void validateStatus(String selectedStatus) {
        List<String> validStatuses = getValidStatuses();
        if (!validStatuses.contains(selectedStatus)) {
            throw new IllegalArgumentException("Invalid status. Valid status values are: " + validStatuses);
        }
    }

    private List<String> getValidStatuses() {
        // Return the list of valid status values
        return Arrays.asList("Draft", "Published");
    }

    private int getMonthIndex(String monthCode) {
        List<Month> months = getMonths();
        for (int i = 0; i < months.size(); i++) {
            Month month = months.get(i);
            if (month.getCode().equals(monthCode)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ResponseEntity<Void> viewIdPut(
            @PathVariable("id") String id,
            @RequestParam("title") String title,
            @RequestParam("day") Integer day,
            @RequestParam("selectedMonth") String selectedMonth,
            @RequestParam("year") Integer year,
            @RequestParam("hour") Integer hour,
            @RequestParam("minute") Integer minute,
            @RequestParam("description") String description,
            @RequestParam("selectedCategories") List<String> selectedCategories,
            @RequestParam("selectedStatus") String selectedStatus) {
        // Update the ViewData with the provided values based on the ID
        ViewData viewData = getViewDataById(id);
        String sameid = viewData.getId();
        viewData.setTitle(title);
        viewData.setDay(day);
        viewData.setSelectedMonth(selectedMonth);
        viewData.setYear(year);
        viewData.setHour(hour);
        viewData.setMinute(minute);
        viewData.setDescription(description);
        viewData.setSelectedCategories(selectedCategories);
        viewData.setSelectedStatus(selectedStatus);

        LocalDate newDate = validateDate(day, selectedMonth, year);
        LocalTime newTime = validateTime(hour, minute);

        validateStatus(selectedStatus);

        String newId = generateId(title, newDate, newTime);
        viewData.setId(newId);

        updateViewData(viewData, sameid);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> viewIdDelete(@PathVariable("id") String id) {
        // Decode the ID parameter
        String decodedId = java.net.URLDecoder.decode(id, StandardCharsets.UTF_8);

        // Delete the ViewData with the decoded ID
        ViewData viewData = getViewDataById(decodedId);
        view_List.remove(viewData);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ViewData>> viewIdCategoriesDateGet(String id,
                                                                  String categories,
                                                                  String date) {
        // Return the list of ViewData objects that match the provided ID, categories, and date
        List<ViewData> searchResults = new ArrayList<>();

        // Perform the search based on the provided parameters
        for (ViewData viewData : view_List) {
            boolean matchesId = viewData.getId().toLowerCase().contains(id.toLowerCase());
            boolean matchesCategories = categories != null && viewData.getSelectedCategories().contains(categories);
            boolean matchesDate = date != null && isDateMatch(viewData, date);

            // Add the view data to the search results if it matches the criteria
            if (matchesId || matchesCategories || matchesDate) {
                searchResults.add(viewData);
            }
        }

        if (!searchResults.isEmpty()) {
            return ResponseEntity.ok(searchResults);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private boolean isDateMatch(ViewData viewData, String date) {
        String[] dateParts = date.split("-");
        if (dateParts.length == 3) {
            int day = Integer.parseInt(dateParts[0]);
            String selectedMonth = dateParts[1];
            int year = Integer.parseInt(dateParts[2]);

            return viewData.getDay() == day &&
                    viewData.getSelectedMonth().equalsIgnoreCase(selectedMonth) &&
                    viewData.getYear() == year;
        }
        return false;
    }
}