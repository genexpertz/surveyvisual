
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

# Define server logic required to draw a histogram ----
# Define server logic required to draw a histogram ----
server <- function(input, output) {

  dbAccess <- ({
    dyn.load('/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server/libjvm.so')
       library(rJava)
        library(RJDBC)

        cp <- c("/home/preethup/hive/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar","/home/preethup/Documents/hbase/lib/hadoop-common-2.6.0-cdh5.4.1.jar")

        .jinit(classpath=cp)

        drv <- JDBC("org.apache.hive.jdbc.HiveDriver","/home/preethup/hive/lib/hive-jdbc-1.1.0-cdh5.4.1-standalone.jar",identifier.quote="`")

        conn <- dbConnect(drv, "jdbc:hive2://localhost:10000/surveyvisual","preethup","")
        result <- dbSendQuery(conn,"select * from age_group")
        d.frame <- fetch(result, n=-1)
        print(d.frame)

    })

  # Histogram of the Old Faithful Geyser Data ----
  # with requested number of bins
  # This expression that generates a histogram is wrapped in a call
  # to renderPlot to indicate that:
  #
  # 1. It is "reactive" and therefore should be automatically
  #    re-executed when inputs (input$bins) change
  # 2. Its output type is a plot
  output$distPlot <- renderPlot({

    x    <- faithful$waiting  
    bins <- 2

    #hist(d.frame$agegroupcount.count, col = "#75AADB", border = "white",
    #     xlab = d.frame$agegroupcount.agegroup,
    #     main = "Age Chart",ylim=c(1,5),xlim=c(0,70),breaks=3)
    barplot(d.frame$agegroupcount.count,names.arg=d.frame$agegroupcount.agegroup,xlab="Age Group",ylab="Count",col="blue", main="Smoking habit chart",border="red")

    })

}

# Create Shiny app ----
shinyApp(ui = ui, server = server)


