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
      menuItem("Agewise Report", tabName = "agewise", icon = icon("group")),
      menuItem("Genderwise Report", tabName = "genderwise", icon = icon("bar-chart-o")),
      menuItem("Placewise Report", tabName = "placewise", icon = icon("fa fa-area-chart")),
      menuItem("Yearwise Report", tabName = "yearwise", icon = icon("calendar"))
    )
  ),
   dashboardBody(
    tabItems(
      
      # First tab content
     tabItem(tabName = "agewise",
          h1("Agewise Report"),
          
          selectInput(inputId = "dataset",
                      h3("Choose a year"),
                      #label = "Choose a year:",
                      choices = c("2010","2011","2012","2013", "2014", "2015","2016","2017"))

        ),
     #second tab content 
     tabItem(tabName = "genderwise",
         h1("Genderwise Report"),
         
         selectInput(inputId = "dataset",
                     h3("Choose a year"),
                     #label = "Choose a year:",
                     choices = c("2010","2011","2012","2013", "2014", "2015","2016","2017"))
    ),

      # Third tab content
      tabItem(tabName = "placewise",
        h1("Placewise Report"),
        
        selectInput(inputId = "dataset",
                    h3("Choose a year"),
                    #label = "Choose a year:",
                    choices = c("2010","2011","2012","2013", "2014", "2015","2016","2017"))
        
      ),      
  
        # Fourth tab content
        tabItem(tabName = "yearwise",
                h1("Yearwise Report"),
                
                selectInput(inputId = "dataset",
                            h3("Choose a year"),
                            #label = "Choose a year:",
                            choices = c("2010","2011","2012","2013", "2014", "2015","2016","2017"))
              
      )
    ),
    tags$head(tags$style(HTML('.shiny-server-account { display: none; }'))),

        # The dynamically-generated user panel
    uiOutput("userpanel")
    ),
    dashboardBody(
        plotOutput(outputId="distPlot")
    )
)

server <- function(input, output, session) {

   fetchDBData <- reactive({
       print("Hello")
   })

  output$userpanel <- renderUI({
    # session$user is non-NULL only in authenticated sessions
    if (!is.null(session$user)) {
      sidebarUserPanel(
        span("Logged in as ", session$user),
        subtitle = a(icon("sign-out"), "Logout", href="__logout__"))

      dbAccess <- ({
        library(rJava)
        library(RJDBC)
        cp <- c("/Users/gireeshbabu/workspace/tools/hive/hive-1.1.0-cdh5.4.1/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar","/Users/gireeshbabu/workspace/tools/hadoop/hbase-1.0.0-cdh5.4.1/lib/hadoop-common-2.6.0-cdh5.4.1.jar");
        .jinit(classpath=cp);
        drv <- JDBC("org.apache.hive.jdbc.HiveDriver","/Users/gireeshbabu/workspace/tools/hive/hive-1.1.0-cdh5.4.1/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar",identifier.quote="`");
        conn <- dbConnect(drv, "jdbc:hive2://localhost:10000/surveyvisual","avin","");
        result <- dbSendQuery(conn,"select * from agegroupcount");
        d.frame <- fetch(result, n=-1);
        print(d.frame);
      })

      output$distPlot <- renderPlot({

        x    <- faithful$waiting
        bins <- 2
        barplot(d.frame$agegroupcount.count,names.arg=d.frame$agegroupcount.agegroup,xlab="Age Group",ylab="Count",col="blue", main="Smoking habit chart",border="red")

      })
    }
  })
}

shinyApp(ui, server)