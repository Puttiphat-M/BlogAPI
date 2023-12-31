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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        test1.setId("TEST-01JAN2021-01.01");
        view_List.add(test1);
        ViewData test2 = new ViewData();
        test2.setTitle("WWW");
        test2.setDay(Integer.valueOf("1"));
        test2.setYear(Integer.valueOf("2021"));
        test2.setHour(Integer.valueOf("1"));
        test2.setMinute(Integer.valueOf("1"));
        test2.setDescription("TEST");
        test2.setSelectedStatus("Draft");
        test2.setSelectedCategories(Arrays.asList("Fantasy", "Sci-Fi"));
        test2.setSelectedMonth("Jan");
        test2.setId("www-01JAN2021-01.01");
        view_List.add(test2);
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

        view_List.add(blog);

        // Perform further processing or save the blog object

        return ResponseEntity.status(HttpStatus.CREATED).body(blog);
    }

    public ViewData getViewDataById(String id) {
        for (ViewData viewData : view_List) {
            if (viewData.getId().equals(id)) {
                return viewData;
            }
        }
        throw new IllegalArgumentException("ViewData not found for ID: " + id);
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
            if (yearValue < 2000 || yearValue > 2100) {
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
        String formattedMonth = date.getMonth().name().substring(0, 3);
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd"));
        String formattedTime = time.format(DateTimeFormatter.ofPattern("HH.mm"));
        for (ViewData viewData : view_List) {
            if (viewData.getId().equals(formattedTitle + "-" + formattedDate + formattedMonth + date.getYear() + "-" + formattedTime)) {
                throw new IllegalArgumentException("ViewData already exists for ID: " + formattedTitle + "-" + formattedDate + formattedMonth + date.getYear() + "-" + formattedTime);
            }
        }
        return formattedTitle + "-" + formattedDate + formattedMonth + date.getYear() + "-" + formattedTime;
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
            @RequestParam("description") String description,
            @RequestParam("day") Integer day,
            @RequestParam("selectedMonth") String selectedMonth,
            @RequestParam("year") Integer year,
            @RequestParam("hour") Integer hour,
            @RequestParam("minute") Integer minute,
            @RequestParam("selectedCategories") List<String> selectedCategories,
            @RequestParam("selectedStatus") String selectedStatus) {
        // Update the ViewData with the provided values based on the ID
        ViewData viewData = getViewDataById(id);
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

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> viewIdDelete(@PathVariable("id") String id) {
        // Delete the ViewData with the provided ID
        ViewData viewData = getViewDataById(id);
        view_List.remove(viewData);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ViewData>> viewIdCategoriesDateGet(String id,
                                                                  String categories,
                                                                  String date) {
        // Return the list of ViewData objects that match the provided ID, categories, and date
        List<ViewData> searchResults = new ArrayList<>();
        //create the categories list
        List<String> categoriesList = new ArrayList<>();
        if (categories != null) {
            categoriesList.add(categories);
        }

        // Perform the search based on the provided parameters
        for (ViewData viewData : view_List) {
            boolean matchesId = id == null || (viewData.getId() != null && viewData.getId().toLowerCase().contains(id.toLowerCase()));
            boolean matchesCategories = categories == null || viewData.getSelectedCategories().stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet())
                    .containsAll(Arrays.stream(categories.split(","))
                            .map(String::trim)
                            .map(String::toLowerCase)
                            .collect(Collectors.toSet()));
            boolean matchesDate = date == null || isDateMatch(viewData, date);
            // Add the view data to the search results if it matches the criteria
            if (matchesId && matchesCategories && matchesDate) {
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
        // Split the date into day, month, and year
        Pattern pattern = Pattern.compile("(\\d+)([a-zA-Z]+)(\\d+)");
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches()) {
            int day = Integer.parseInt(((Matcher) matcher).group(1));
            String selectedMonth = matcher.group(2);
            int year = Integer.parseInt(matcher.group(3));

            // Compare the date components with the view data
            return viewData.getDay().equals(day) &&
                    viewData.getSelectedMonth().equalsIgnoreCase(selectedMonth) &&
                    viewData.getYear().equals(year);
        }
        return false;
    }
}