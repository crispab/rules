module Main exposing (main)

import Browser
import Html exposing (Html, div, text)


main : Program () Model Msg
main =
    Browser.element
        { init = init
        , view = view
        , update = update
        , subscriptions = subscriptions
        }


type alias Model =
    { str : String
    }


type Msg
    = NoOp


init : () -> ( Model, Cmd Msg )
init _ =
    ( { str = "hej igen"
      }
    , Cmd.none
    )


view : Model -> Html Msg
view model =
    div []
        [ text model.str
        ]


update : Msg -> Model -> ( Model, Cmd msg )
update msg model =
    case msg of
        NoOp ->
            ( model, Cmd.none )


subscriptions : Model -> Sub msg
subscriptions model =
    Sub.none
