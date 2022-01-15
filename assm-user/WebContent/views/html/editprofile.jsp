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
    <title>Profile</title>
    <link rel="icon" href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1" type="image/x-icon">
    <script src="../js/components/header.js" defer></script>
    <script src="../js/components/footer.js" defer></script>
</head>

<body>
    <header-component></header-component>
    <main style="display: flex;min-height: 100vh;">
        <div class="container">
            <div class="columns is-centered mt-6">
                <div class="column is-4">
                    <h1 class="block title has-text-centered">UPDATE PROFILE</h1>
                    <form action="" method="post" class="box" id="form-login">
                        <div class="field">
                            <label for="" class="label">Username</label>
                            <div class="control">
                                <input type="text" class="input">
                            </div>
                        </div>
                        <div class="field">
                            <label for="" class="label">Password</label>
                            <div class="control">
                                <input type="password" class="input">
                            </div>
                        </div>
                        <div class="field">
                            <label for="" class="label">Fullname</label>
                            <div class="control">
                                <input type="text" class="input">
                            </div>
                        </div>
                        <div class="field">
                            <label for="" class="label">Email</label>
                            <div class="control">
                                <input type="email" class="input">
                            </div>
                        </div>
                        <hr>
                        <div class="field">
                            <div class="control">
                                <button class="button is-primary is-fullwidth" type="submit">Update</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
    <footer-component></footer-component>
</body>

</html>