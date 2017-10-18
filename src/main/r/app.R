library(shiny)
#library(plotly)
library(shinydashboard)

ui <- dashboardPage(
dashboardHeader(title = "SurveyVisual"),
dashboardSidebar(
sidebarMenu(
menuItem("Agewise Report", tabName = "overview", icon = icon("group")),
menuItem("Genderwise Report", tabName = "dashboard", icon = icon("bar-chart-o")),
menuItem("Placewise Report", tabName = "calender", icon = icon("fa fa-area-chart")),
menuItem("Yearwise Report", tabName = "dashboardyear", icon = icon("calendar"))
)
),
dashboardBody(
tabItems(

# First tab content
tabItem(tabName = "overview",
h1("Agewise Report"),

selectInput(inputId = "dataset",
h3("Choose a year"),
#label = "Choose a year:",in
choices = c("2010","2011","2012","2013", "2014", "2015","2016","2017"),
multiple = TRUE
),
textInput("text", "Target percentage :", "")

),
#second tab content
tabItem(tabName = "dashboard",
h1("Genderwise Report"),

selectInput(inputId = "dataset",
h3("Choose a year"),
#label = "Choose a year:",
choices = c("2010","2011","2012","2013", "2014", "2015","2016","2017"))

),

# Third tab content
tabItem(tabName = "calender",
h1("Placewise Report"),

selectInput(inputId = "dataset",
h3("Choose a year"),
#label = "Choose a year:",
choices = c("2010","2011","2012","2013", "2014", "2015","2016","2017"))

),

# Fourth tab content
tabItem(tabName = "dashboardyear",
h1("Yearwise Report"),

selectInput(inputId = "dataset",
h3("Choose a year"),
#label = "Choose a year:",
choices = c("2010","2011","2012","2013", "2014", "2015","2016","2017"))

)
),
tags$head(tags$style(HTML('.shiny-server-account { display: none; }'))),
uiOutput("userpanel"),
plotOutput(outputId="distPlot")
)
)

server <- function(input, output) {

    fetchDBData <- reactive({
        print("Hello")
    })

    output$userpanel <- renderUI({
        # session$user is non-NULL only in authenticated sessions
        dbAccess <- ({
            dyn.load("/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server/libjvm.so");
            library(rJava)
            library(RJDBC)
            cp <- c("/home/avin/hive/hive-1.1.0-cdh5.4.1/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar","/home/avin/hbase/hbase-1.0.0-cdh5.4.1/lib/hadoop-common-2.6.0-cdh5.4.1.jar")
            .jinit(classpath=cp)
            drv <- JDBC("org.apache.hive.jdbc.HiveDriver","/home/avin/hive/hive-1.1.0-cdh5.4.1/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar",identifier.quote="`")
            conn <- dbConnect(drv, "jdbc:hive2://localhost:10000/surveyvisual","avin","")
            comma.str = paste(as.character(input$dataset),collapse = ",");
            selectedyears <- dbSendQuery(conn,paste("select * from agegroupcount where year in (",comma.str,")"))
            d.frame <- fetch(selectedyears, n=-1)
            print(d.frame)
            #take each year count with condition data.f['column']=='2017'
            #if(input$dataset){
            #
            #}
            years = input$dataset
            yearList = list()
            i <- 0
            ag = '31-40'
            for(e in years){
                yearList[[e]] =  subset(d.frame,d.frame$'agegroupcount.year' == e & d.frame$'agegroupcount.agegroup' == ag)
                i <- i + 1
            }
            print('year array-')
            print(yearList)
            cntV = c()
            yearV= c()
            for(le in yearList){
                cntV = append(cntV,le$'agegroupcount.count')
                print(paste("cntv-",cntV));
                yearV = append(yearV,le$'agegroupcount.year')
                print(paste("yearV-",yearV));
            }

            line.count = c()
            line.count = append(line.count,cntV[1])
            for(e in cntV ){
                line.count = append(line.count,e*.9)
                print(paste("e-",e))
            }
            #cut out last element
            line.count = line.count[-length(line.count)]

            print(paste("line-",line.count))
            output$distPlot <- renderPlot({
                barplot(cntV,names.arg=yearV)
                lines(line.count)
            })
            #var = data.f$count
            #barplot(var)
            # v = (23, 45, 35, 25) //each year count
            #for(e of var){
            #  v = data.frame(expr[expr$dataset == "count"])
            #}
            #pr = ()


            #
            #print(d.frame)


        })

        #output$distPlot <- renderPlot({
        #  x    <- faithful$waiting
        #  bins <- 2
        #barplot(d.frame$agegroupcount.count,names.arg=d.frame$agegroupcount.agegroup,xlab="Age Group",ylab="Count",col="blue", main="Smoking habit chart",border="red")
        #   ggplot(data = d.frame, aes(x = input$dataset , y = , fill = Stage.of.Change)) +
        #   geom_bar()
        #  })
    })
}

shinyApp(ui, server)