;;;***************************
;;;* DEFFACTS KNOWLEDGE BASE *
;;;***************************

(deffacts MAIN::knowledge-base
    (welcome (message WelcomeMessage))
    (goal (variable beer.type))
    (legalanswers (values yes no))
    (displayanswers (values "Yes" "No"))

    (rule (if fruity is yes)
          (then flavour is fruity))
    (rule (if fruity is no)
          (then flavour is dry))
    (question (variable fruity)
                 (query fruity.query))

    (rule (if flavour is fruity and
                        blonde is yes)
          (then beer.type is blonde.lager))
    (rule (if flavour is fruity and
                        blonde is no)
           (then beer.type is faro))
    (question (variable blonde)
                  (query blonde.query))

    (rule (if flavour is dry and
                    blonde is yes)
          (then beer.type is pale.ale))
    (rule (if flavour is dry and
                    blonde is no)
          (then beer.type is dark.ale))
    (question (variable blonde)
              (query blonde.query))

    (answer (prefix "I think your beer is a ") (variable beer.type) (postfix ".")))
