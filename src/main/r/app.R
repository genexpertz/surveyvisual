library(shiny)
library(plotly)
library(shinydashboard)


ui <- dashboardPage(
dashboardHeader(title = "SurveyVisual"),
dashboardSidebar(sidebarMenu(
menuItem(
"Agewise Report",
tabName = "overview",
icon = icon("group")
),
menuItem(
"Genderwise Report",
tabName = "dashboard",
icon = icon("bar-chart-o")
),
menuItem(
"Placewise Report",
tabName = "calender",
icon = icon("fa fa-area-chart")
),
menuItem(
"Yearwise Report",
tabName = "dashboardyear",
icon = icon("calendar")
)
)),
dashboardBody(
tabItems(
# First tab content
tabItem(
tabName = "overview",
h1("Agewise Report"),

selectInput(
inputId = "dataset",selected = "2005",
h3("Choose a year"),
#label = "Choose a year:",in
choices = c("2005","2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"),
multiple = TRUE
),
selectInput(inputId = "agInput", h3("Choose an age group"),
choices=c("11-20","21-30","31-40","41-50","51-60","61-70","71-80","81-90")),
#textInput("text","Target percentage is 10"),
notificationItem("Target Percentage is 10"),
submitButton(text = "Submit",icon="Refresh"),
plotOutput("agewisePlot")

),
#second tab content
tabItem(
tabName = "dashboard",
h1("Genderwise Report"),

selectInput(
inputId = "dataset1",selected = "2005",
h3("Choose a year"),
#label = "Choose a year:",in
choices = c("2005","2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"),
multiple = TRUE
),

selectInput(inputId = "gnInput", h3("Choose gender"),
choices=c("m","f")),
notificationItem("Target Percentage is 10"),
submitButton(text = "Submit",icon="refresh"),
plotOutput("genderwisePlot")
),

# Third tab content
tabItem(
tabName = "calender",
h1("Placewise Report"),

selectInput(
inputId = "dataset2",selected = "2005",
h3("Choose a year"),
#label = "Choose a year:",
choices = c("2005","2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"),
multiple = TRUE
),

selectInput(inputId = "plInput", h3("Choose a place"),
choices=c("Alappuzha","Kollam","Eranakulam","Idukki","Kottayam")),
#textInput("text","Target percentage is 10"),
notificationItem("Target Percentage is 10"),
submitButton(text = "Submit",icon="refresh"),
plotOutput("placewisePlot")

),

# Fourth tab content
tabItem(
tabName = "dashboardyear",
h1("Yearwise Report"),

selectInput(
inputId = "dataset3", selected = "2005",
label = "Choose a year:",
choices = c("2005","2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"),
multiple = TRUE
),

notificationItem("Target Percentage is 10"),
submitButton(text = "Submit",icon=("refresh")),
plotOutput("yearwisePlot")
)

),
tags$head(tags$style(
HTML('.shiny-server-account { display: none; }')
)),
#uiOutput("userpanel"),
plotOutput(outputId = "distPlot")
)
)

server <- function(input, output) {

    #output$userpanel <- renderUI({

    dbAccess <- function(key){

        dyn.load("/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server/libjvm.so");
        library(rJava)
        library(RJDBC)
        cp <- c("/home/avin/hive/hive-1.1.0-cdh5.4.1/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar","/home/avin/hbase/hbase-1.0.0-cdh5.4.1/lib/hadoop-common-2.6.0-cdh5.4.1.jar")
        .jinit(classpath=cp)
        drv <- JDBC("org.apache.hive.jdbc.HiveDriver","/home/avin/hive/hive-1.1.0-cdh5.4.1/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar",identifier.quote="`")
        conn <- dbConnect(drv, "jdbc:hive2://localhost:10000/surveyvisual","avin","")

        #comma.str = paste(as.character(input$dataset), collapse = ",")
        #print("comma.str")
        #print(comma.str)
        selectedyears = c()
        if(key == "agewise"){
            comma.str = paste(as.character(input$dataset), collapse = ",")
            print("comma.str")
            print(comma.str)
            selectedyears <-
            dbSendQuery(conn,
            paste("select * from agegroup where year in (", comma.str, ")"))
            #d.frame <- fetch(selectedyears, n = -1)
            #print(d.frame)
            #d.frame
        } else if(key == "genderwise"){
            comma.str = paste(as.character(input$dataset1), collapse = ",")
            print("comma.str")
            print(comma.str)
            selectedyears <-
            dbSendQuery(conn,
            paste("select * from gendergroup where year in (", comma.str, ")"))
            #d.frame <- fetch(selectedyears, n = -1)
            #print(d.frame)
            # d.frame
        } else if(key == "placewise"){
            comma.str = paste(as.character(input$dataset2), collapse = ",")
            print("comma.str")
            print(comma.str)
            selectedyears <-
            dbSendQuery(conn,
            paste("select * from placegroup where year in (", comma.str, ")"))
        } else if(key == "yearwise"){
            comma.str = paste(as.character(input$dataset3), collapse = ",")
            print("comma.str")
            print(comma.str)
            selectedyears <-
            dbSendQuery(conn,
            paste("select * from yeargroup where yeargroup in (", comma.str, ")"))
        }

        d.frame <- fetch(selectedyears, n = -1)
        print(d.frame)
        d.frame
    }

    output$agewisePlot <- renderPlot({
        d.frame = dbAccess("agewise")
        years = input$dataset
        yearList = list()
        ag = input$agInput
        print(paste("ag",ag))
        for (e in years) {
            yearList[[e]] =  subset(
            d.frame,
            d.frame$'agegroup.year' == e &
            d.frame$'agegroup.agegroup' == ag
            )
        }
        print('year array-')
        print(yearList)
        cntV = c()
        yearV = c()
        for (le in yearList) {
            cntV = append(cntV, le$'agegroup.count')
            print(paste("cntv-", cntV))
            yearV = append(yearV, le$'agegroup.year')
            print(paste("yearV-", yearV))

        }

        line.count = c()
        line.count = append(line.count, cntV[1])
        for (e in cntV) {
            line.count = append(line.count, e * .9)
            print(paste("e-", e))
        }
        #cut out last element
        line.count = line.count[-length(line.count)]
        print(paste("line-", line.count))
        barplot(cntV,names.arg=yearV,xlab="Year",ylab="Count",col="yellow",main = paste("Year wise count for age-group:",ag))
        lines(line.count,col="aquamarine4")
    })

    output$genderwisePlot <- renderPlot({
        d.frame = dbAccess("genderwise")
        years = input$dataset1
        yearList = list()
        ag = input$gnInput
        print(paste("ag",ag))
        for (e in years) {
            yearList[[e]] =  subset(
            d.frame,
            d.frame$'gendergroup.year' == e &
            d.frame$'gendergroup.gendergroup' == ag
            )
        }
        print('year array-')
        print(yearList)
        cntV = c()
        yearV = c()
        for (le in yearList) {
            cntV = append(cntV, le$'gendergroup.count')
            print(paste("cntv-", cntV))

            yearV = append(yearV, le$'gendergroup.year')
            print(paste("yearV-", yearV))

        }

        line.count = c()
        line.count = append(line.count, cntV[1])
        for (e in cntV) {
            line.count = append(line.count, e * .9)
            print(paste("e-", e))
        }
        #cut out last element
        line.count = line.count[-length(line.count)]
        print(paste("line-", line.count))
        barplot(cntV,names.arg=yearV,xlab="Year",ylab="Count",col="yellow",main = paste("Gender wise count for age-group:",ag))
        lines(line.count,col="aquamarine4")
    })

    output$placewisePlot <- renderPlot({
        d.frame = dbAccess("placewise")
        years = input$dataset2
        yearList = list()
        ag = input$plInput
        print(paste("ag",ag))
        for (e in years) {
            yearList[[e]] =  subset(
            d.frame,
            d.frame$'placegroup.year' == e &
            d.frame$'placegroup.placegroup' == ag
            )
        }
        print('year array-')
        print(yearList)
        cntV = c()
        yearV = c()
        for (le in yearList) {
            cntV = append(cntV, le$'placegroup.count')
            print(paste("cntv-", cntV))

            yearV = append(yearV, le$'placegroup.year')
            print(paste("yearV-", yearV))

        }

        line.count = c()
        line.count = append(line.count, cntV[1])
        for (e in cntV) {
            line.count = append(line.count, e * .9)
            print(paste("e-", e))
        }
        #cut out last element
        line.count = line.count[-length(line.count)]
        print(paste("line-", line.count))
        barplot(cntV,names.arg=yearV,xlab="Year",ylab="Count",col="yellow",main = paste("Place wise count for:",ag))
        lines(line.count,col="aquamarine4")
    })


    output$yearwisePlot <- renderPlot({
        d.frame = dbAccess("yearwise")
        years = input$dataset3
        yearList = list()
        #ag = input$agInput
        #print(paste("ag",ag))
        for (e in years) {
            yearList[[e]] =  subset(
            d.frame,
            d.frame$'yeargroup.year' == e
            )
        }
        print('year array-')
        print(yearList)
        cntV = c()
        yearV = c()
        for (le in yearList) {
            cntV = append(cntV, le$'yeargroup.count')
            print(paste("cntv-", cntV))
            yearV = append(yearV, le$'yeargroup.year')
            print(paste("yearV-", yearV))

        }

        line.count = c()
        line.count = append(line.count, cntV[1])
        for (e in cntV) {
            line.count = append(line.count, e * .9)
            print(paste("e-", e))
        }
        #cut out last element
        line.count = line.count[-length(line.count)]
        print(paste("line-", line.count))
        #if(!is.null(cntV)){
        barplot(cntV,names.arg=yearV,xlab="Year",ylab="Count",col="yellow")
        lines(line.count,col="aquamarine4")
        #}
    })


    #}
    #)
}



shinyApp(ui, server)
