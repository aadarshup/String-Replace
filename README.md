# String-Replace
(Text and csv file are compatible)
1. Starting with app.log file, this is not mandatory file, can be created while running the application, used to print logs of application run.
2. config.properties file is mandatory and required to give input file path, debug mode, old string which you want to replace with new striing, and new string needed which should overrite your old string.
3. TextFileEdit.java is actual java code application file, mandory file, containing rules to replace old string. Condition is the string which you want to replace must be a single word, for instance if you want to replace success in your text or csv file, so this code will not replace "success" in "successful".
4. LoggerUtil.java is log java file, mandatory file, in which all types of exception given to handle in java code.
