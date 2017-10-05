
library(shiny)

# Define UI for app that draws a histogram ----
ui <- fluidPage(

  # App title ----
  titlePanel("Hello Shiny!"),

    # Sidebar panel for inputs ----
    sidebarPanel(

      # Input: Slider for the number of bins ----
     selectInput(inputId = "dataset",
                  label = "Choose a year:",
                  choices = c("2013", "2014", "2015"))

    ),

    # Main panel for displaying outputs ----
    mainPanel(

      # Output: Histogram ----
      plotOutput(outputId = "distPlot")

    )
  )
)

# Define server logic required to draw a barplot ----
server <- function(input, output) {

  dbAccess <- ({
        library(rJava)
        library(RJDBC)
        cp <- c("/home/avin/hive/hive-1.1.0-cdh5.4.1/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar","/home/avin/hbase/hbase-1.0.0-cdh5.4.1/lib/hadoop-common-2.6.0-cdh5.4.1.jar");
        .jinit(classpath=cp);
        drv <- JDBC("org.apache.hive.jdbc.HiveDriver","/home/avin/hive/hive-1.1.0-cdh5.4.1/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar",identifier.quote="`");
        conn <- dbConnect(drv, "jdbc:hive2://localhost:10000/surveyvisual","avin","");
        result <- dbSendQuery(conn,"select * from agegroupcount");
        d.frame <- fetch(result, n=-1);
        print(d.frame);
    })

  # Bar plot to find the frequncy of smokers in various agegroup's  ----
  output$distPlot <- renderPlot({

    x    <- faithful$waiting  
    bins <- 2

    barplot(d.frame$agegroupcount.count,names.arg=d.frame$agegroupcount.agegroup,xlab="Age Group",ylab="Count",col="blue", main="Smoking habit chart",border="red")

    })

}

shinyApp(ui = ui, server = server)


