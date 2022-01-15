<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
        integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <title>Login</title>
    <link rel="icon" href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1" type="image/x-icon">
</head>

<body>
    <section class="hero is-fullheight">
        <div class="hero-body">
            <div class="container">
                <div class="columns is-centered">
                    <div class="column is-two-thirds-tablet is-half-desktop is-one-third-widescreen">
                        <div class="card">
                            <header class="card-header">
                                <p class="card-header-title">
                                    <span class="icon">
                                        <i class="fas fa-lock"></i>
                                    </span>
                                    <span>LOGIN</span>
                                </p>
                            </header>
                            <div class="card-content">
                                <form action="" method="post">
                                    <div class="field">
                                        <label for="" class="label">Username</label>
                                        <div class="control">
                                            <input name="" type="text" class="input" required autofocus>
                                        </div>
                                    </div>
                                    <div class="field">
                                        <label for="" class="label">Password</label>
                                        <div class="control">
                                            <input name="" type="password" class="input" required autofocus>
                                        </div>
                                    </div>
                                    <div class="field is-horizontal">
                                        <div class="control">
                                            <label class="checkbox">
                                                <input type="checkbox" name="" checked>
                                                <span class="control-label">Remember me</span>
                                            </label>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="field">
                                        <div class="control">
                                            <button type="submit" class="button is-fullwidth is-info">
                                                <span>Login</span>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>

</html>