library(shiny)
library(shinydashboard)

ui <- dashboardPage(
    dashboardHeader(title = "SurveyVisual",
    dropdownMenu(type = "notifications",
    notificationItem(
        text = "5 new users today",
        icon("users")
    )
    )
    ),
    dashboardSidebar(
    sidebarMenu(
      menuItem("Agewise Report", tabName = "overview", icon = icon("group")),
      menuItem("Genderwise Report", tabName = "dashboard", icon = icon("bar-chart-o")),
      menuItem("Placewise Report", tabName = "calender", icon = icon("fa fa-area-chart") ),
      menuItem("Yearwise Report", tabName = "calender", icon = icon("calendar") )
    )
  ),
   dashboardBody(
    tabItems(
      
      # First tab content
     tabItem(tabName = "overview",
          h1("Agewise Report"),
          
          selectInput(inputId = "dataset",
                      h3("Choose a year"),
                      #label = "Choose a year:",
                      choices = c("2010","2011","2012","2013", "2014", "2015","2016","2017"))

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
        tabItem(tabName = "dashboard",
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

server <- function(input, output, session) {

   fetchDBData <- reactive({
       print("Hello")
   })

  output$userpanel <- renderUI({
    # session$user is non-NULL only in authenticated sessions
      dbAccess <- ({
        dyn.load("/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre/lib/server/libjvm.dylib")
        library(rJava)
        library(RJDBC)
        cp <- c("/Users/gireeshbabu/workspace/tools/hive/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar","/Users/gireeshbabu/workspace/tools/hadoop/hbase-1.0.0-cdh5.4.1/lib/hadoop-common-2.6.0-cdh5.4.1.jar");
        .jinit(classpath=cp);
        drv <- JDBC("org.apache.hive.jdbc.HiveDriver","/Users/gireeshbabu/workspace/tools/hive/hive-1.1.0-cdh5.4.1/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar",identifier.quote="`");
        conn <- dbConnect(drv, "jdbc:hive2://localhost:10000/surveyvisual","gireeshbabu","");
        result <- dbSendQuery(conn,"select * from agegroupcount");
        d.frame <- fetch(result, n=-1);
        print(d.frame);
      })

      output$distPlot <- renderPlot({

        x    <- faithful$waiting
        bins <- 2
        barplot(d.frame$agegroupcount.count,names.arg=d.frame$agegroupcount.agegroup,xlab="Age Group",ylab="Count",col="blue", main="Smoking habit chart",border="red")

      })
  })
}

shinyApp(ui, server)