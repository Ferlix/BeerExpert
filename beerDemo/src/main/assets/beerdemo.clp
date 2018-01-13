;;;***************************
;;;* DEFFACTS KNOWLEDGE BASE *
;;;***************************

(deffacts MAIN::knowledge-base
    (goal (variable beer.type))
    (legalanswers (values yes no))
    (displayanswers (values "Yes" "No"))

    (rule (if advanced is yes)
          (then beer.type is lambic))
    (question (variable advanced)
                  (query advanced.query))

    (rule (if fruity is yes)
          (then flavour is fruity))
    (rule (if fruity is no)
          (then flavour is dry))
    (question (variable fruity)
                 (query fruity.query))

    (rule (if flavour is fruity and
                        sweet is yes)
          (then sweetness is sweet))
    (rule (if flavour is fruity and
                        sweet is no)
           (then sweetness is notsweet))
    (question (variable sweet)
                  (query sweetness.query))

    (rule (if flavour is dry and
                        sweet is yes)
          (then beer.type is dark.lager))
    (rule (if flavour is dry and
                        sweet is no)
           (then sweetness is notsweet))
    (question (variable sweet)
                  (query sweetness.query))

    (rule (if sweetness is sweet and
                           dark.colour is yes)
          (then beer.type is dark.ale))
    (rule (if sweetness is sweet and
                           dark.colour is no)
          (then beer.type is wheat.ale))
    (question (variable dark.colour)
                  (query dark.colour.query))

    (rule (if sweetness is notsweet and
                           hops is yes)
          (then beer.type is indian.pale.ale))
    (rule (if sweetness is notsweet and
                           hops is no)
          (then beer.type is pale.ale))
    (question (variable hops)
                  (query hops.query))

    (rule (if flavour is dry and sweetness is notsweet and
                                              hops is yes)
          (then beer.type is indian.pale.lager))
    (rule (if flavour is dry sweetness is notsweet and
                                          hops is no)
          (then beer.type is pale.lager))
    (question (variable hops)
                  (query hops.query))

    (answer (variable beer.type)))
